package com.ggd543.filter

import org.slf4j.LoggerFactory

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-1-16
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
class IPFilter extends javax.servlet.Filter {
  private val logger = LoggerFactory.getLogger(getClass)
  private var ip = "localhost"

  override def destroy() {
    logger.debug("IPFilter.destroy()")
  }

  @throws(classOf[javax.servlet.ServletException])
  @throws(classOf[java.io.IOException])
  override def doFilter(req: javax.servlet.ServletRequest, resp: javax.servlet.ServletResponse, chain: javax.servlet.FilterChain) {
    val remoteHost = req.getRemoteHost
    logger.debug("remoteHost: " + remoteHost)
    val serverName = req.getServerName
    if (ip.equals(serverName)) {
      chain.doFilter(req, resp);
    } else {
      val pw = resp.getWriter
      pw.append("Only allow 127.0.0.1 visit")
      pw.flush
      pw.close()
    }
  }

  @throws(classOf[javax.servlet.ServletException])
  override def init(config: javax.servlet.FilterConfig) {
    logger.debug("IPFilter.init")
    this.ip = config.getInitParameter("ip")
    logger.debug("ip: " + this.ip)
  }

}
