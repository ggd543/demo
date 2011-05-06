package utils


import org.apache.log4j.{PropertyConfigurator, Logger}

object LogUtils {
    println("<LogUtils>")
  //  var LOG4J_LOGGER=Logger.getLogger("LOG4JDEMO")
  //  val url=getClass().getResource("log4j.properties")
  //  println("the url of log4j properties: "+url)
  //  PropertyConfigurator.configure(url)
  val LOG4J_LOGGER = Logger.getLogger("LOG4JDEMO")
}