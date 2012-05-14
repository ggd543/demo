package com.ggd543.driver

import java.sql.DriverManager
import java.io.PrintWriter

/**
 *
 * User: 刘永健
 * Date: 12-4-15
 * Time: 下午10:56
 * To change this template use File | Settings | File Templates.
 */

object  MysqlDriverDemo extends App{
  DriverManager.setLogWriter(new PrintWriter(System.out))
   val driverDesc = "com.mysql.jdbc.Driver";
   val jdbcUrl = "jdbc:mysql://localhost:3306/test"
   Class.forName(driverDesc)
  com.mysql.jdbc.Driver
   DriverManager.getConnection(jdbcUrl, "root", "1234")

}
