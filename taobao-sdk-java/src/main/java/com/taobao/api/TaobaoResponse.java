package com.taobao.api;

import java.io.Serializable;
import java.util.Map;

/**
 * 调用Top的API返回的response ErrorCode错误码 body 响应的body部分 
 * 
 * @author cilai
 * @since 1.0, 2010-5-4 下午04:19:22
 */
public class TaobaoResponse implements Serializable {

	private static final long serialVersionUID = 5014379068811962022L;

	private String errorCode;
	private String msg;
	private String subCode;
	private String subMsg;
	private String body;
	private Map<String, String> params;
	
	public TaobaoResponse() {
		super();
	}

	private TaobaoResponse(String body, String errorCode, String msg) {
		super();
		this.body = body;
		this.errorCode = errorCode;
		this.msg = msg;
	}

	public TaobaoResponse(TaobaoResponse rsp) {
		this(rsp.body, rsp.errorCode, rsp.msg );
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSubCode() {
		return this.subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getSubMsg() {
		return this.subMsg;
	}

	public void setSubMsg(String subMsg) {
		this.subMsg = subMsg;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	
	public boolean isSuccess(){
		return this.errorCode == null && this.subCode == null ;
	}
}
