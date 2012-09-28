package demo

import org.apache.commons.lang.StringUtils

/**
 *
 * User: 刘永健
 * Date: 12-7-24
 * Time: 下午4:49
 * To change this template use File | Settings | File Templates.
 */

object StringPerformanceTest extends scala.App {

  val STRING = "    555555599999999999999999aaa sss ssaaaaaaaaaaaaaatasdtatastasrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa      "
  val TARGET = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
  val REPLACE = "b";
  val N = 100000

  println("hello")
  testMethod(N)("jdk replace: "){
    jdkReplace(STRING,TARGET, REPLACE)
  }

  testMethod(N)("StringUtil replace: "){
    apacheReplace(STRING,TARGET, REPLACE)
  }

  testMethod(N)("jdk trim: "){
    jdkTrim(STRING)
  }

  testMethod(N)("StringUtil trim: "){
    apacheTrim(STRING)
  }

  def jdkReplace(str: String, target: String, replace: String) {
    str.replace(target, replace);
  }

  def apacheReplace(str: String, target: String, replace: String) {
    StringUtils.replace(str, target, replace);
  }

  def jdkTrim(str: String) {
    str.trim();
  }

  def apacheTrim(str: String) {
    StringUtils.trim(str)
  }

  def testMethod(n: Int)(promt: String )(doMethod:  => Unit) {
    var avgNanoSec = 0.0
    for (i <- 1 to n) {
      var start = System.nanoTime();
      doMethod
      var end = System.nanoTime();
      val time = end - start;
      avgNanoSec = 1.0 * ((i - 1) * avgNanoSec + time) / i;
    }
    println(promt + avgNanoSec+" ns");
  }


  List(1,2,3).sortWith((a,b) => a < b)

}
