/*
 * Date: 12-11-22
 * Time: 上午11:39
 * To change this template use File | Settings | File Templates.
 */
package com.ggd543

import util.Random
import java.util.Date

/**
 * @author 刘永健(http://my.oschina.net/aiguozhe)
 */
class A {
  def func(i:Int) = {
    if (i> 1000) {
      // 需要调用B提供的接口（服务)
      val result = ClassInvoker.invoke("com.ggd543.B","getTime")
      result.asInstanceOf[Date].getTime()
    }else{
      i + 1
    }
  }
}

object A{
  def random() = new Random().nextInt()
}


