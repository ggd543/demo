package easyconf

import com.germinus.easyconf.EasyConf

/**
 *
 * User: 刘永健
 * Date: 12-2-15
 * Time: 下午1:44
 * To change this template use File | Settings | File Templates.
 */

object EasyConfDemo {
  def main(args: Array[String]): Unit = {
    println(EURO_TO_DOLLARS_RATIO)
    println("--- SUPPORTED_CURRENCIES ---")
    SUPPORTED_CURRENCIES.foreach(println)
    println("----------------------------")
    println("--- TRUSTED_CURRENCIES ---")
    TRUSTED_CURRENCIES.foreach(println)
    println("--------------------------")

  }

  //  val EURO_TO_DOLLARS_RATIO = EasyConf.getConfiguration("calculator").getProperties.getDouble("euro-to-dollars", 1.2)

  val EURO_TO_DOLLARS_RATIO = getProperties().getDouble("euro-to-dollars");
  val SUPPORTED_CURRENCIES = getProperties().getStringArray("supported-currencies");
  val TRUSTED_CURRENCIES = getProperties().getStringArray("trusted-currencies");
  val CONVERSION_ALLOWED = getProperties().getBoolean("conversion-allowed");

  private def getProperties() = {
    EasyConf.getConfiguration("travelsky","calculator").getProperties();
  }

}
