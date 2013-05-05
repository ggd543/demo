/*
 * @(#) FuxkPropertyDefiner.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-02
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import reflect.BeanProperty
import ch.qos.logback.core.PropertyDefinerBase

class FuxkPropertyDefiner extends PropertyDefinerBase {
  @BeanProperty
  var shape: String = _
  @BeanProperty
  var color: String = _
  @BeanProperty
  var size: Int = _

  def getPropertyValue: String = "Fuxk"
}
