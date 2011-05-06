package com.taobao.api;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.taobao.api.internal.parser.json.ObjectJsonParser;
import com.taobao.api.internal.parser.xml.ObjectXmlParser;
import com.taobao.api.internal.util.RequestParametersHolder;
import com.taobao.api.internal.util.TaobaoLogger;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.internal.util.TaobaoUtils;
import com.taobao.api.internal.util.WebUtils;
import com.taobao.api.internal.util.XmlUtil;
import com.taobao.api.internal.util.json.JSONReader;

/**
 * 基于REST的TOP客户端。
 *
 * @author carver.gu <a href="mailto:opensupport@taobao.com">opensupport</a>
 * @since 1.0, Sep 13, 2009
 */
public class DefaultTaobaoClient implements TaobaoClient {

    private static final String APP_KEY = "app_key";
    private static final String FORMAT = "format";
    private static final String METHOD = "method";
    private static final String TIMESTAMP = "timestamp";
    private static final String VERSION = "v";
    private static final String SIGN = "sign";
    private static final String PARTNER_ID = "partner_id";
    private static final String SESSION = "session";

    private String serverUrl;
    private String appKey;
    private String appSecret;
    private String format = Constants.FORMAT_JSON;

    private int connectTimeout = 0;
    private int readTimeout = 0;

    public DefaultTaobaoClient(String serverUrl, String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.serverUrl = serverUrl;
    }

    public DefaultTaobaoClient(String serverUrl, String appKey, String appSecret, String format) {
        this(serverUrl, appKey, appSecret);
        this.format = format;
    }

    public DefaultTaobaoClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout) {
        this(serverUrl, appKey, appSecret, format);
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    @SuppressWarnings("unchecked")
    public <T extends TaobaoResponse> T execute(TaobaoRequest request) throws ApiException {
        return (T) execute(request, null);
    }


    @SuppressWarnings("unchecked")
    public <T extends TaobaoResponse> T execute(TaobaoRequest request, String session) throws ApiException {
        String requestName = request.getClass().getName();
        String responseName = "com.taobao.api.response." + requestName.substring(requestName.lastIndexOf(".") + 1, requestName.length() - 7) + "Response";
        Class<T> clazz;
        try {
            clazz = (Class<T>) Class.forName(responseName);
        } catch (ClassNotFoundException e) {
            throw new ApiException(e);
        }
        TaobaoParser<T> parser = null;
        if (Constants.FORMAT_XML.equals(this.format)) {
            parser = new ObjectXmlParser<T>(clazz);
        } else {
            parser = new ObjectJsonParser<T>(clazz);
        }
        return _execute(request, parser, session);
    }

    private <T extends TaobaoResponse> T _execute(TaobaoRequest request, TaobaoParser<T> parser, String session) throws ApiException {
        Map<String, Object> rt = doPost(request, session);
        if (rt == null) return null;
        T taobaoResponse = null;
        try {
            taobaoResponse = parse(parser, (String) rt.get("rsp"), request.getApiMethodName());
        } catch (RuntimeException e) {//parser错误
            TaobaoLogger.logBizError((String) rt.get("rsp"));
            throw e;
        }
        taobaoResponse.setParams((TaobaoHashMap) rt.get("textParams"));
        if (!taobaoResponse.isSuccess()) {
            TaobaoLogger.logBizError(taobaoResponse.getBody());
        }
        return taobaoResponse;
    }

    public Map<String, Object> doPost(TaobaoRequest request, String session) throws ApiException {
        Map<String, Object> result = new HashMap<String, Object>();
        RequestParametersHolder requestHolder = new RequestParametersHolder();
        String rsp = null;
        TaobaoHashMap appParams = new TaobaoHashMap(request.getTextParams());
        requestHolder.setApplicationParams(appParams);

        // 添加协议级请求参数
        TaobaoHashMap protocalMustParams = new TaobaoHashMap();
        protocalMustParams.put(METHOD, request.getApiMethodName());
        protocalMustParams.put(VERSION, "2.0");
        protocalMustParams.put(APP_KEY, appKey);
        Long timestamp = request.getTimestamp();//允许用户设置时间戳
        if (timestamp == null) {
            timestamp = new Date().getTime();
        }
        DateFormat df = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
        df.setTimeZone(Constants.TOP_TIMEZONE);
        protocalMustParams.put(TIMESTAMP, df.format(new Date(timestamp)));//因为沙箱目前只支持时间字符串，所以暂时用Date格式
        requestHolder.setProtocalMustParams(protocalMustParams);

        TaobaoHashMap protocalOptParams = new TaobaoHashMap();
        protocalOptParams.put(FORMAT, format);
        protocalOptParams.put(SESSION, session);
        protocalOptParams.put(PARTNER_ID, Constants.SDK_VERSION);
        requestHolder.setProtocalOptParams(protocalOptParams);

        // 添加签名参数
        try {
            protocalMustParams.put(SIGN, TaobaoUtils.signTopRequest(requestHolder, appSecret));
        } catch (Exception e) {
            throw new ApiException(e);
        }

        StringBuffer urlSb = new StringBuffer(serverUrl);
        try {
            String sysMustQuery = WebUtils.buildQuery(requestHolder.getProtocalMustParams(), WebUtils.DEFAULT_CHARSET);
            String sysOptQuery = WebUtils.buildQuery(requestHolder.getProtocalOptParams(), WebUtils.DEFAULT_CHARSET);

            urlSb.append("?");
            urlSb.append(sysMustQuery);
            if (sysOptQuery != null & sysOptQuery.length() > 0) {
                urlSb.append("&");
                urlSb.append(sysOptQuery);
            }
        } catch (IOException e) {
            throw new ApiException(e);
        }

        try {
            // 是否需要上传文件
            if (request instanceof TaobaoUploadRequest) {
                TaobaoUploadRequest uRequest = (TaobaoUploadRequest) request;
                Map<String, FileItem> fileParams = TaobaoUtils.cleanupMap(uRequest.getFileParams());
                rsp = WebUtils.doPost(urlSb.toString(), appParams, fileParams, connectTimeout, readTimeout);
            } else {
                rsp = WebUtils.doPost(urlSb.toString(), appParams, connectTimeout, readTimeout);
            }
        } catch (IOException e) {
            throw new ApiException(e);
        }
        result.put("rsp", rsp);
        result.put("textParams", appParams);
        result.put("protocalMustParams", protocalMustParams);
        result.put("protocalOptParams", protocalOptParams);
        result.put("url", urlSb.toString());
        return result;
    }

    public <T extends TaobaoResponse> T parse(TaobaoParser<T> parser, String rsp, String apiName) throws ApiException {
        T taobaoResponse = null;

        try {
            taobaoResponse = parser.getClazz().newInstance();
        } catch (Exception e) {
            throw new ApiException("class instance failure !", e);
        }

        int xmlErrorIndex = rsp.indexOf("<error_response>");//top mapping返回的xml标准错误的头为"<?xml version=\"1.0\" encoding=\"utf-8\" ?><error_response>"
        if (rsp.startsWith("{\"error_response\":")) {
            JSONReader reader = new JSONReader();
            Map<?, ?> rspJson = (Map<?, ?>) reader.read(rsp);
            Map<?, ?> errJson = (Map<?, ?>) rspJson.get("error_response");
            taobaoResponse.setErrorCode(errJson.get("code").toString());
            taobaoResponse.setMsg((String) errJson.get("msg"));
            taobaoResponse.setSubCode((String) errJson.get("sub_code"));
            taobaoResponse.setSubMsg((String) errJson.get("sub_msg"));
        } else if (xmlErrorIndex != -1 && xmlErrorIndex < 50) {
            Document xmlDoc = XmlUtil.parseDocument(rsp);
            Element element = xmlDoc.getDocumentElement();
            taobaoResponse.setErrorCode(XmlUtil.getChildAsString(element, "code"));
            taobaoResponse.setMsg(XmlUtil.getChildAsString(element, "msg"));
            taobaoResponse.setSubCode(XmlUtil.getChildAsString(element, "sub_code"));
            taobaoResponse.setSubMsg(XmlUtil.getChildAsString(element, "sub_msg"));
        } else {
            T tempTaobaoResponse = parser.parse(rsp, apiName);
            if (tempTaobaoResponse != null) {
                taobaoResponse = tempTaobaoResponse;
            } else {
                taobaoResponse.setErrorCode("sdk parse error");
            }
        }

        taobaoResponse.setBody(rsp);
        return taobaoResponse;
    }
}
