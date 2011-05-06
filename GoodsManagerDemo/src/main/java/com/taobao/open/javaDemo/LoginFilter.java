package com.taobao.open.javaDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 系统的filter，请求的大坝，负责权限认证
 * @author zhudi
 *
 */
public class LoginFilter implements Filter {
	final private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * sessionKey失效时间，开放平台是10分钟，那我们就设置9分钟。
	 */
	private final long INSENSITIVE_TIME = 9L*60L*1000L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String authcode = request.getParameter("authcode");
		String sessionKey = request.getParameter("top_session");

        logger.debug("authcode="+authcode+" sessionKey="+sessionKey);
		/**
		 * 如果传过来的参数有授权码，则用授权码去换取sessionKey
		 */
		if (authcode != null) {
//			String url =Config.GET_SESSION_URL+ "?authcode="+ authcode;
			String url =Config.GET_SESSION_URL+"?appkey=test&secret=fYJ8Qw8HwMY%3D&nick=alipublic01&callback=http://localhost:8080/gmd/center.do";
            logger.debug("GET_SESSION_URL: "+url);
			response.sendRedirect(url);
			return ;
		}
		/**
		 * 如果传过来的参数带sessionKey，说明是开放平台回调过来的，
		 * 拿到sessionKey，关联用户和该sessionKey，这里使用的是保存在用户cookie中的办法关联。
		 */
		if (sessionKey != null) {
            logger.debug("callback from open.taobao.com");
			//关联sessionKey
			Cookie cookie = new Cookie("sessionKey", sessionKey);
			response.addCookie(cookie);
			//记录最后访问时间
			response.addCookie(new Cookie("lastVisit", String.valueOf(System.currentTimeMillis())));
			request.setAttribute("sessionKey", sessionKey);
			//授权认证通过，跳转到接下来的页面
			response.sendRedirect("center.do");
			return;
		} else {
			/**
			 * 参数中不带sessionKey，那么去查看用户的cookie，看是否已经授权过了
			 */
			Cookie[] cookies = request.getCookies();
			boolean isOutOfTime = false;//是否超时
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if (cookie.getName().equals("sessionKey")) {
						request.setAttribute("sessionKey", cookie.getValue());
					}else if (cookie.getName().equals("lastVisit")) {
						//检查是否sessionKey是否超时
						if(System.currentTimeMillis()-Long.parseLong(cookie.getValue())>INSENSITIVE_TIME){
							//设置超时表示
							isOutOfTime = true;
						}
					}
				}
			}
			/**
			 * 如果没有授权，或者sessionKey超时失效，跳转到授权页面
			 */
			if(request.getAttribute("sessionKey")==null||isOutOfTime){
				request.setAttribute("appKey", Config.appKey);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return ;
			}else{
				//不要忘记随时记录最后访问时间，以判断sessionKey是否超时
				response.addCookie(new Cookie("lastVisit", String.valueOf(System.currentTimeMillis())));
			}
		}
		try{
			chain.doFilter(request, response);
		}catch(Exception e){
			/**
			 * 你的错误处理，这边只是打印出来
			 */
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
