package demo

import java.io.PrintWriter
import org.apache.log4j.{SimpleLayout, ConsoleAppender, Level, Logger}
/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-1-1
 * Time: 19:22:01
 * To change this template use File | Settings | File Templates.
 */

object Log4jDemo1 {
  def main(args: Array[String]) {
    val consoleAppender = new ConsoleAppender
    consoleAppender.setWriter(new PrintWriter(System.out))
    consoleAppender.setLayout(new SimpleLayout)
//    val logger = Logger.getRootLogger
    val logger = Logger.getLogger("name")    
    logger.setLevel(Level.DEBUG)
    logger.addAppender(consoleAppender)
    logger.info("info message", new Throwable("fuck", new Throwable("Hello world")))
    logger.warn("warn message")
    logger.info(new Exception("Hello world infomation"))

    val unnamedLogger=Logger.getLogger("abc")
    println(unnamedLogger.getAppender("aaa"))
    
  }

  
}