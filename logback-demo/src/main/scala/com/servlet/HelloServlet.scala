package com.servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import org.slf4j.LoggerFactory

class HelloServlet extends HttpServlet {
  private val logger = LoggerFactory.getLogger(classOf[HelloServlet])

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    logger.info("serverName: " ++ req.getServerName + " contextPath" + req.getContextPath);
    val pw = resp.getWriter()
    pw.println("Hello world")
    pw.flush()
    pw.close()
  }
}
