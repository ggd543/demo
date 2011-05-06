package demo


import java.io.PrintWriter
import org.apache.log4j.{ConsoleAppender, SimpleLayout, Level, Logger}

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-1-2
 * Time: 11:29:17
 * To change this template use File | Settings | File Templates.
 */

object Log4jDemo3 {
  def main(args: Array[String]): Unit = {
    val consoleAppender = new ConsoleAppender
    consoleAppender.setWriter(new PrintWriter(System.out))
    consoleAppender.setLayout(new SimpleLayout)
    val logger = Logger.getRootLogger
    logger.setLevel(Level.DEBUG)
    logger.addAppender(consoleAppender)
    val t1 = new Thread1(logger)
    val t2 = new Thread2(logger)
    t1.start
    t2.start
  }
}

class Thread1(val logger: Logger) extends Thread {
  val msg = new Range(1, 1000, 1).mkString("[", ",", "]")

  override def run() {
    for (i <- 1 to 10) {
      Thread.sleep((1000 * Math.random).asInstanceOf[Int])
      logger.debug(msg)
    }
  }
}

class Thread2(val logger: Logger) extends Thread {
  val msg = "hello world"

  override def run() {
    for (j <- 1 to 100) {
      Thread.sleep((1000 * Math.random).asInstanceOf[Int])
      logger.debug(msg)
    }

  }
}