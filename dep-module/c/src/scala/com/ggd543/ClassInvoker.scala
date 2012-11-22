package com.ggd543

import java.lang.reflect.Modifier


/*
 * Date: 12-11-22
 * Time: 下午1:36
 * To change this template use File | Settings | File Templates.
 */

/**
 * @author 刘永健(http://my.oschina.net/aiguozhe)          
 */
object ClassInvoker {
  private val classLoader = Thread.currentThread().getContextClassLoader();

  def invoke(className: String, methodName: String, args: Object*): Object = {
    invoke(false, className, methodName, args: _*)
  }

  def invoke(isNewInstance: Boolean, className: String, methodName: String, args: Object*): Object={
    val clazz = classLoader.loadClass(className);
    val method = clazz.getMethod(methodName, args.map(_.getClass): _*);
    if (method == null){
      throw new NoSuchMethodException()
    }
    var targetObject:Object = null;
    if (!Modifier.isStatic(method.getModifiers) && isNewInstance){
      targetObject = clazz.newInstance().asInstanceOf[Object];
    }
    method.invoke(targetObject, args: _*)
  }
}
