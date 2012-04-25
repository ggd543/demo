package com.ggd543.dbutil

import org.apache.commons.dbutils.QueryRunner
import org.apache.commons.dbutils.handlers.BeanListHandler
import scala.collection.JavaConversions._
/**
 *
 * User: 刘永健
 * Date: 12-3-26
 * Time: 上午11:12
 * To change this template use File | Settings | File Templates.
 */

object BeanListHandlerDemo extends App {
  val qr = new QueryRunner()
  val conn = DB.getConn()
  val sqlStr = """
      select city_cn AS cityCN, city_en AS cityEN, is_domestic AS isDomestic, is_hot_city AS isHotCity, city_code AS cityCode,
       airport_en AS airportEN, airport_cn AS airportCN
      from t_city
      where city_code = ?
      """
  try {
    val cityList= qr.query(conn,sqlStr, new BeanListHandler(classOf[City]), "CAN")
    println("airport_en    airport_cn    is_domestic    is_hot_city   city_code")
    for(city <- cityList){
      println(city.getAirportEN+ " "+city.getAirportCN+ " "+city.getIsDomestic()+" "+city.getIsHotCity+" "
        +city.getCityCode)
    }
  } finally {
    conn.close
  }

}
