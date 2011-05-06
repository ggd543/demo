package com.ggd543.listener

import javax.servlet.{ServletContextEvent, ServletContextListener}
import org.slf4j.LoggerFactory

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-1-16
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */

class DumpListener extends ServletContextListener {
  private var logger = LoggerFactory.getLogger(getClass)

  def contextInitialized(sce: ServletContextEvent) = {
    logger.debug("-----------------DumpListener----------------")
    logger.debug("dumpMessage: " + sce.getServletContext.getInitParameter("dumpMessage"))
//    Thread.sleep(5000L)
    logger.debug("---------------------------------------------");
  }

  def contextDestroyed(sce: ServletContextEvent) = {

    logger.debug("===============DumpListener destroy========================")
    logger.debug("Byebye DumpListener")
//    Thread.sleep(5000L)
    logger.debug("=======================================")
  }
}