/*
 * Date: 12-11-22
 * Time: 下午2:18
 * To change this template use File | Settings | File Templates.
 */
package com.ggd543

import java.util.Date

/**
 * @author 刘永健(http://my.oschina.net/aiguozhe)          
 */
object MainTestApp {
  def main(args: Array[String]): Unit = {
    val result = ClassInvoker.invoke("com.ggd543.Test","getDate");
    println(result)
    ClassInvoker.invoke(true , "com.ggd543.Test", "say", "Archer")
    ClassInvoker.invoke(true , "com.ggd543.Test", "printCurrentDate")
  }
}

class Test {
  def say(msg: String) = {
    println("hello "+msg)
  }
  def printCurrentDate() = {
    println("now is "+new Date())
  }
}

object Test {
  def getDate() = new Date()
}
