package demo

/**
 *
 * User: 刘永健
 * Date: 12-2-2
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 */

object MapTest {
  def mutableHashMap(n: Int) {
    val m = new scala.collection.mutable.HashMap[Int, Int];
    var i = 0;
    while (i < n) {
      i = i + 1; m.put(i, i);
    };
  }

  def javaHashMap(n: Int) {
    val m = new java.util.HashMap[Int, Int];
    var i = 0;
    while (i < n) {
      i = i + 1; m.put(i, i);
    };
  }

  def javaConcurrentHashMap(n: Int) {
    val m = new java.util.concurrent.ConcurrentHashMap[Int, Int];
    var i = 0;
    while (i < n) {
      i = i + 1; m.put(i, i);
    };
  }

  def testMethod(n: Int)(m: Int)(body: (Int) =>Unit){
    var avgMilliSec = 0.0
    for(i <- 1 to n){
      var start = System.currentTimeMillis();
      body(m)
      var end = System.currentTimeMillis();
      val time = end - start;
      avgMilliSec = 1.0*  ((i-1)* avgMilliSec +  time) / i;
    }
    println("avg time: "+avgMilliSec);
  }


  def main(args: Array[String]): Unit = {
    testMethod(100)(10000)(mutableHashMap)
    testMethod(100)(1000000)(mutableHashMap)
    println
    testMethod(100)(10000)(javaHashMap)
    testMethod(100)(1000000)(javaHashMap)
    println
    testMethod(100)(10000)(javaConcurrentHashMap)
    testMethod(100)(1000000)(javaConcurrentHashMap)
  }
}