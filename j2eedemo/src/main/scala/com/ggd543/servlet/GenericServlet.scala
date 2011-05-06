package com.ggd543.servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import javax.servlet.{ServletContext, ServletConfig}
import org.slf4j.LoggerFactory

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-1-16
 * Time: 2:47
 * To change this template use File | Settings | File Templates.
 */

class GenericServlet extends HttpServlet {
  private var servletContext: ServletContext = _
  private var logger = LoggerFactory.getLogger(getClass())

  override def init(config: ServletConfig) = {
    this.servletContext = config.getServletContext
    logger.debug("servletName: " + config.getServletName)
  }

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {
    val pw = resp.getWriter()
    pw.println("serverName: " + req.getServerName);
    pw.println("serverPort: " + req.getServerPort);
    pw.println();
    pw.println("pathInfo: " + req.getPathInfo)
    pw.println("serveltPath: " + req.getServletPath)
    pw.println("contextPath: " + req.getContextPath);
    pw.println("contextPaht returned by servletContext: " + servletContext.getContextPath)
    pw.println()
    pw.println("requestURI: " + req.getRequestURI)
    pw.println("requestURL: " + req.getRequestURL)
    pw.println();
    pw.println(servletContext.getRealPath(""));
    pw.flush
    pw.close
  }
}