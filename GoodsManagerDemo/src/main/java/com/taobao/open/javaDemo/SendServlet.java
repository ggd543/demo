package com.taobao.open.javaDemo;


import java.io.IOException;
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
import com.taobao.open.javaDemo.domain.LogisticsCompaniesGetResponse;
import com.taobao.open.javaDemo.domain.LogisticsCompany;

/**
 * 负责发货的请求处理
 * @author zhudi
 *
 */
public class SendServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5843289900983463785L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String tId = request.getParameter("tId");
		String orderType = request.getParameter("order_type");
		/**
		 *  如果发货类型是空的，则显示发货的表单页面
		 */
		if(orderType==null){
			request.setAttribute("tid",tId);
			//去开放平台拿物流公司代码，供用户选择
			request.setAttribute("company_code",  getCompaniesResponse());
			RequestDispatcher rd = request.getRequestDispatcher("send.jsp");
			rd.forward(request, response);
		}else{
			/**
			 * 如果有发货类型，则转发发货请求到开放平台
			 */
			TreeMap<String, String> apiparamsMap = new TreeMap<String, String>();
			// 组装协议参数。
			apiparamsMap.put("method", "taobao.delivery.send");
			apiparamsMap.put("app_key", Config.appKey);
			apiparamsMap.put("timestamp", new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").format(new Date()));
			apiparamsMap.put("format", "xml");
			apiparamsMap.put("session", (String) request.getAttribute("sessionKey"));
			apiparamsMap.put("v", "2.0");
			/**
			 * 如果是虚拟发货
			 */
			if("virtual_goods".equals(orderType)){
				apiparamsMap.put("order_type", "virtual_goods");
				apiparamsMap.put("tid", request.getParameter("tid"));
			}else if("delivery_needed".equals(orderType)){
				/**
				 * 是物流发货，则转发请求
				 */
				@SuppressWarnings("unchecked")
				Map<String,String[]> paras = request.getParameterMap();
				for (Iterator<String> iterator = paras.keySet().iterator(); iterator
						.hasNext();) {
					String key = iterator.next();
					apiparamsMap.put(key, paras.get(key)[0]);
				}
			}else{
				throw new RuntimeException();
			}
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
			/**
			 * 拿到返回结果
			 */
			String result = Util.getResult(Config.SANDBOX_URL,param.toString().substring(1));
			/**
			 * 这里不拿xml解析引擎解析了，只是简单的判断是否成功
			 */
			if(result.matches(".*<shipping><is_success>true</is_success></shipping>.*")){
				response.sendRedirect("success.jsp");
			}else{
				/**
				 * 你的错误处理
				 */
				throw new RuntimeException();
			}
		}
	}
	/**
	 * 获取物流公司代码
	 * @return
	 */
	private LogisticsCompaniesGetResponse getCompaniesResponse(){
		
		TreeMap<String, String> apiparamsMap = new TreeMap<String, String>();
		// 组装协议参数。
		apiparamsMap.put("method", "taobao.logistics.companies.get");
		apiparamsMap.put("app_key", Config.appKey);
		apiparamsMap.put("timestamp", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(new Date()));
		apiparamsMap.put("format", "xml");
		apiparamsMap.put("v", "2.0");
		// 组装应用参数
		apiparamsMap.put("fields", "id,code,name");
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
		/**
		 * 拿到结果
		 */
		String result = Util.getResult(Config.SANDBOX_URL,param.toString().substring(1));
		/**
		 * 设置XML解析引擎需要的别名映射
		 */
		Map<String,Class<?>> mapping = new HashMap<String, Class<?>>();
		mapping.put("logisticsCompaniesGetResponse",LogisticsCompaniesGetResponse.class);
		mapping.put("logisticsCompany",LogisticsCompany.class);
		/**
		 * 拿到解析结果返回
		 */
		LogisticsCompaniesGetResponse tradesSoldGetResponse =(LogisticsCompaniesGetResponse) Converter.converter(mapping,result);
		
		return tradesSoldGetResponse;
	}
}
