package com.ggd543.servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import org.slf4j.LoggerFactory
import javax.servlet.{ServletContext, ServletConfig}

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-1-16
 * Time: 11:33
 * To change this template use File | Settings | File Templates.
 */

class HelloServlet extends HttpServlet {
  private val logger = LoggerFactory.getLogger(getClass())
  private var servletContext: ServletContext = _

  override def init(config: ServletConfig) = {
    this.servletContext = config.getServletContext
    logger.debug("servletName: " + config.getServletName)
  }

  override def init() {
    logger.debug(getClass().getSimpleName + " ")
  }

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {
    val pw = resp.getWriter();
    pw.println("serverName: " + req.getServerName);
    pw.println("serverPort: "+req.getServerPort);
    pw.println();
    pw.println("pathInfo: " + req.getPathInfo)
    pw.println("servletPath: " + req.getServletPath)
    pw.println("contextPath: " + req.getContextPath);
    pw.println("contextPaht returned by servletContext: " + servletContext.getContextPath)
    pw.println()
    pw.println("requestURI: " + req.getRequestURI)
    pw.println("requestURL: " + req.getRequestURL)
    pw.flush
    pw.close
  }
}