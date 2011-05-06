package com.taobao.open.javaDemo;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobao.open.javaDemo.Util.Converter;
import com.taobao.open.javaDemo.Util.Util;
import com.taobao.open.javaDemo.domain.Area;
import com.taobao.open.javaDemo.domain.AreasGetResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 拿到地区码，异步ajax调用
 * @author zhudi
 * Servlet implementation class AreaAsynchServlet
 */
public class AreaAsynchServlet extends HttpServlet {
	
   /**
    * 缓存地区码
    */
	private Area[] areas = null;
	/**
	 * 输出area对象使用的引擎
	 */
	private XStream xstream =null;
      
    /**
     * 初始化的时候去拿地区码，之后缓存在系统中   
     */
	@Override
	public void init() throws ServletException {
		
		super.init();
		TreeMap<String, String> apiparamsMap = new TreeMap<String, String>();
		/**
		 *  组装协议参数。
		 */
		apiparamsMap.put("method", "taobao.areas.get");
		apiparamsMap.put("app_key", Config.appKey);
		apiparamsMap.put("timestamp", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(new Date()));
		apiparamsMap.put("format", "xml");
		apiparamsMap.put("v", "2.0");
		/**
		 *  组装应用参数
		 */
		apiparamsMap.put("fields", "id,type,name,parent_id,zip");
		/**
		 *  获得签名。第二个参数为分配给您的APP_SECRET
		 */
		String sign = Util.sign(apiparamsMap, Config.appSecret);
		/**
		 *  组装协议参数sign
		 */
		apiparamsMap.put("sign", sign);
		/**
		 * 拼装参数
		 */
		StringBuilder param = new StringBuilder();
		for (Iterator<Map.Entry<String, String>> it = apiparamsMap.entrySet()
				.iterator(); it.hasNext();) {
			Map.Entry<String, String> e = it.next();
			param.append("&").append(e.getKey()).append("=").append(
					e.getValue());
		}
		/**
		 * 发送请求到开放平台，拿到结果
		 */
		String result = Util.getResult(Config.SANDBOX_URL,param.toString().substring(1));
		/**
		 * 设置标签别名，让XML解析引擎能够解析
		 */
		Map<String,Class<?>> mapping = new HashMap<String, Class<?>>();
		mapping.put("areasGetResponse",AreasGetResponse.class);
		mapping.put("area",Area.class);
		/**
		 * XML解析引擎解析
		 */
		areas = ((AreasGetResponse) Converter.converter(mapping,result)).getAreas();
		/**
		 * 设置输出引擎
		 */
		xstream = new XStream(new DomDriver()); 
		xstream.alias("area",Area.class);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1297648749581565025L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 设置Ajax响应头信息
		 */
		response.setContentType("text/xml,charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader("Expires", 0);
		Writer writer = null;
		try{	
			writer=response.getWriter();
			/**
			 * 拿到前台传过来的parentID
			 */
			String parentId = request.getParameter("parentId");
			
			writer.write("<areas>");
			/**
			 * 查找所有parentID为前台传过来的Area返回
			 */
			for (Area area : areas) {
				if(area.getParentId().equals(parentId)){
					writer.write(xstream.toXML(area));
				}
			}
			writer.write("</areas>");
		}finally{
			/**
			 * 记得关闭
			 */
			if(writer!=null){
				writer.close();
			}
		}
	  
	}

}
