/*
 * @(#) FuxkFilter.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-03
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import ch.qos.logback.core.filter.Filter
import ch.qos.logback.core.spi.FilterReply
import ch.qos.logback.classic.spi.ILoggingEvent
import org.apache.commons.lang.StringUtils

class FuxkFilter extends Filter[ILoggingEvent] {
  def decide(event: ILoggingEvent): FilterReply = {
    val  message = event.getMessage;
    if (StringUtils.containsIgnoreCase(message, "fuxk")) FilterReply.DENY else FilterReply.DENY
  }
}
