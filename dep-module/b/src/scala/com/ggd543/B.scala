/*
 * Date: 12-11-22
 * Time: 下午3:48
 * To change this template use File | Settings | File Templates.
 */
package com.ggd543

import java.util.Date

/**
 * @author 刘永健(http://my.oschina.net/aiguozhe)          
 */
class B {
  def func(msg: String) ={
    if ("A" == msg){
      "hello "+ ClassInvoker.invoke("com.ggd543.A","random").toString()
    }else{
      "hello "+ msg
    }

  }

}
object B{
  def getTime() = new Date()
}