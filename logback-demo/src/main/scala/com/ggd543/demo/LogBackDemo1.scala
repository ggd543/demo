/*
 * @(#) LogBackDemo1.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-02
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import ch.qos.logback.classic.LoggerContext
import org.slf4j.LoggerFactory

object LogBackDemo1 {
  val loggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
  var logger = loggerContext.getLogger(LogBackDemo1.getClass)

  def main(args: Array[String]): Unit = {

    println()
    println(loggerContext.getProperty("firstName"))
    println(loggerContext.getProperty("version"))
    println(loggerContext.getProperty("lastName"))
    println(loggerContext.getProperty("nickName"))
    println(System.getProperty("nickName"))

    println()

    logger.warn("warn fuxk")
    logger.info("info fuxk")

    logger.debug("info fuxk")

    println("----------- ")
    logger.info("info hello")
    logger.info("info fuxk")
    //    logger.addAppender();

  }
}
