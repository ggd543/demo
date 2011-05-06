package com.taobao.open.javaDemo;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobao.open.javaDemo.Util.Converter;
import com.taobao.open.javaDemo.Util.Util;
import com.taobao.open.javaDemo.domain.Order;
import com.taobao.open.javaDemo.domain.Trade;
import com.taobao.open.javaDemo.domain.TradesSoldGetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 显示卖家已卖出的交易数据
 *
 * @author zhudi
 */
public class ShowTradeServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     */
    private static final long serialVersionUID = -5843289900983463785L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     * <p/>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 拿结果
         */
        logger.debug("------------------------------------------------------------");
        String result = Util.getResult(Config.SANDBOX_URL, createRequestParam(request));
        logger.debug("url: " + new URL(Config.SANDBOX_URL + "?" + createRequestParam(request)));
        logger.debug(result);
        /**
         * 设置映射
         */
        Map<String, Class<?>> mapping = new HashMap<String, Class<?>>();
        mapping.put("tradesSoldGetResponse", TradesSoldGetResponse.class);
        mapping.put("trade", Trade.class);
        mapping.put("order", Order.class);
        /**
         * 解析
         */
        TradesSoldGetResponse tradesSoldGetResponse = (TradesSoldGetResponse) Converter.converter(mapping, result);
        request.setAttribute("taobaoResponse", tradesSoldGetResponse);
        /**
         * 跳转
         */
        RequestDispatcher rd = request.getRequestDispatcher("showTrades.jsp");
        rd.forward(request, response);

    }

    /*
      * 组装请求参数
      */

    private String createRequestParam(HttpServletRequest request) {
        TreeMap<String, String> apiparamsMap = new TreeMap<String, String>();
        // 组装协议参数。
        apiparamsMap.put("method", "taobao.trades.sold.get");
        apiparamsMap.put("app_key", Config.appKey);
        apiparamsMap.put("timestamp", new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss").format(new Date()));
        apiparamsMap.put("format", "xml");
//		apiparamsMap.put("format", "json");
        apiparamsMap.put("session", (String) request.getAttribute("sessionKey"));
        apiparamsMap.put("v", "2.0");
        apiparamsMap.put("start_created", "2010-11-20 00:00:00");
        // 组装应用参数
//        seller_nick,buyer_nick,title,type,created,sid,tid,seller_rate,buyer_rate,status,payment,discount_fee,adjust_fee,post_fee,total_fee,pay_time,end_time,modified,consign_time,buyer_obtain_point_fee,point_fee,real_point_fee,received_payment,commission_fee,pic_path,num_iid,num_iid,num,price,cod_fee,cod_status,shipping_type,receiver_name,receiver_state,receiver_city,receiver_district,receiver_address,receiver_zip,receiver_mobile,receiver_phone,orders.title,orders.pic_path,orders.price,orders.num,orders.iid,orders.num_iid,orders.sku_id,orders.refund_status,orders.status,orders.oid,orders.total_fee,orders.payment,orders.discount_fee,orders.adjust_fee,orders.sku_properties_name,orders.item_meal_name,orders.buyer_rate,orders.seller_rate,orders.outer_iid,orders.outer_sku_id,orders.refund_id,orders.seller_type
        apiparamsMap.put("fields", "seller_nick,buyer_nick,title,type,created,sid,tid,seller_rate,buyer_rate,status,payment,discount_fee,adjust_fee,post_fee,total_fee,pay_time,end_time,modified,consign_time,buyer_obtain_point_fee,point_fee,real_point_fee,received_payment,commission_fee,pic_path,iid,num,price,cod_fee,cod_status,shipping_type,receiver_name,receiver_state,receiver_city,receiver_district,receiver_address,receiver_zip,receiver_mobile,receiver_phone,orders.title,orders.pic_path,orders.price,orders.num,orders.iid,orders.sku_id,orders.refund_status,orders.status,orders.total_fee,orders.payment,orders.discount_fee,orders.adjust_fee,orders.sku_properties_name,orders.item_meal_name,orders.buyer_rate,orders.seller_rate,orders.outer_iid,orders.outer_sku_id,orders.refund_id,orders.seller_type");
//		apiparamsMap.put("fields", "seller_nick, buyer_nick, title, type, created, sid, tid, seller_rate, buyer_rate, status, payment, discount_fee, adjust_fee, post_fee, total_fee, pay_time, end_time, modified, consign_time, buyer_obtain_point_fee, point_fee, real_point_fee, received_payment, commission_fee, pic_path, iid, num_iid, num, price, cod_fee, cod_status, shipping_type, receiver_name, receiver_state, receiver_city, receiver_district, receiver_address, receiver_zip, receiver_mobile, receiver_phone, orders");
        // 获得签名。第二个参数为分配给您的APP_SECRET
        String sign = Util.sign(apiparamsMap, Config.appSecret);
        // 组装协议参数sign
        apiparamsMap.put("sign", sign);

        StringBuilder param = new StringBuilder();
        for (Iterator<Map.Entry<String, String>> it = apiparamsMap.entrySet()
                .iterator(); it.hasNext();) {
            Map.Entry<String, String> e = it.next();
            param.append("&").append(e.getKey()).append("=").append(
                    e.getValue());
        }

        return param.toString().substring(1);
	}
}
