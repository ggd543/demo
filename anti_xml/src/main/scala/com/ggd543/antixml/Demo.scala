package com.ggd543.antixml

import com.codecommit.antixml.XML

/**
 *
 * User: 刘永健
 * Date: 12-4-30
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */

object Demo {
  def main(args: Array[String]): Unit = {
    val xmlDesc = """<?xml version="1.0" encoding="UTF-8"?>
    <employees>
      <employee>
        <name>Aiguozhe</name>
        <sex>m</sex>
        <age>30</age>
      </employee>
    </employees> """;
    val xml = XML.fromString(xmlDesc);
//    println(xml);
    val result = xml \ "employee";
    println(result)
  }
}
