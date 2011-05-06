package com.ggd543.filter

import javax.servlet._
import org.slf4j.LoggerFactory

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-1-16
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */

class CharsetEncodingFilter extends Filter {
  private val logger = LoggerFactory.getLogger(getClass)
  private var encoding = "GBK"

  def destroy = {
    logger.debug("CharsetEncodingFilter.destroy")
  }

  def doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) = {
    response.setCharacterEncoding(encoding)
    chain.doFilter(request, response)
  }

  def init(filterConfig: FilterConfig) = {
    this.encoding = filterConfig.getInitParameter("encoding")
    logger.debug("CharsetEncodingFilter.init")
    logger.debug("CharsetEncoding: "+this.encoding)
  }
}