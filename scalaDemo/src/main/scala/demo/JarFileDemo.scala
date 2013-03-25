package demo

import java.util.jar.JarFile
import java.io.File

/*
 * @(#) JarFileDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-25
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
object JarFileDemo {
  import scala.collection.JavaConversions._

  def main(args: Array[String]):Unit = {
    val uri = getClass.getResource("/res.zip").toURI
    val jarFile = new JarFile(new File(uri))
    jarFile.entries().foreach{
      e => println(e)
    }
  }
}
