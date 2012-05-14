package com.ggd543.mulerestletdemo

import org.mule.api.lifecycle.Callable
import org.mule.api.MuleEventContext

class GreetingComponent   extends Callable {

  def onCall(eventContext: MuleEventContext) = {
      val name = eventContext.getMessage.getPayload.asInstanceOf[String]
      sayHello(name)
  }

  def sayHello(name: String) = {
    val msg = "hello, "+name
    println(msg)
    msg
  }
}