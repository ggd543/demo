package com.ggd543.directive

import org.apache.velocity.runtime.directive.Directive
import org.apache.velocity.context.InternalContextAdapter
import org.apache.velocity.runtime.parser.node.{SimpleNode, Node}
import collection.mutable.HashMap
import org.apache.commons.lang.StringUtils
import java.io.{StringWriter, Writer}

/**
 *
 * User: 刘永健
 * Date: 12-1-31
 * Time: 下午4:45
 * To change this template use File | Settings | File Templates.
 */

class CacheDirective extends Directive {
  private val cacheImp = new HashMap[String, String]()

  def getName = "cache"

  def getType = BLOCK

  def render(context: InternalContextAdapter, writer: Writer, node: Node) = {
    //获得缓存信息
    val sn_region = node.jjtGetChild(0).asInstanceOf[SimpleNode]
    val region = sn_region.value(context).asInstanceOf[String];
    val sn_key = node.jjtGetChild(1).asInstanceOf[SimpleNode];
    val key = sn_key.value(context).asInstanceOf[String];

    val body = node.jjtGetChild(2);
    //检查内容是否有变化
    String tpl_key = key + "@" + region;
    String body_tpl = body.literal();
    println("body: " + body)

    //TODO
    throw new UnsupportedOperationException
  }
}