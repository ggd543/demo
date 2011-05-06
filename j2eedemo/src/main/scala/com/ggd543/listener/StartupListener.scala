package com.ggd543.listener

import javax.servlet.{ServletContextEvent, ServletContextListener}
import org.slf4j.LoggerFactory

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-1-16
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */

class StartupListener extends ServletContextListener {
  private val logger = LoggerFactory.getLogger(getClass())

  def contextInitialized(sce: ServletContextEvent) = {
    val servletContext = sce.getServletContext()
    logger.debug("-----------StartupListener------------------")
    logger.debug("admin: " + servletContext.getInitParameter("admin"))
//    Thread.sleep(5000L)
    logger.debug("--------------------------------------------");
  }

  def contextDestroyed(sce: ServletContextEvent) = {
    logger.debug("===========StartupListener destroy==================")
    logger.debug("GoodBye StartupListener");
//    Thread.sleep(5000L)
    logger.debug("====================================================");
  }
}