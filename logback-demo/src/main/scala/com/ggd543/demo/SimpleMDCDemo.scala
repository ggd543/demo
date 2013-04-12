package com.ggd543.demo

import org.slf4j.{LoggerFactory, MDC}

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-4-8
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */
object SimpleMDCDemo {
  private val logger = LoggerFactory.getLogger(SimpleMDCDemo.getClass)

  def main(args: Array[String]): Unit = {
    MDC.put("first", "liu")
    MDC.put("last", "yongjian")
    logger.info("hello world")
  }
}
