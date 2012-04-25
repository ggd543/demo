package demo

/**
 *
 * User: 刘永健
 * Date: 12-2-2
 * Time: 上午10:49
 * To change this template use File | Settings | File Templates.
 */

object LoopTest {
  def forLoop(n: Int) {
    var total = 0;
    for (i <- 0 until n) {
      total += i
    };
  }

  def whileLoop(n: Int) {
    var total = 0;
    var i = 0;
    while (i < n) {
      i = i + 1; total += i
    };
  }

  def testMethod(n: Int)(m: Int)(body: (Int) => Unit) {
    var avgMilliSec = 0.0
    for (i <- 1 to n) {
      var start = System.currentTimeMillis();
      body(m)
      var end = System.currentTimeMillis();
      val time = end - start;
      avgMilliSec = 1.0 * ((i - 1) * avgMilliSec + time) / i;
    }
    println("avg time: " + avgMilliSec);
  }

  def main(args: Array[String]): Unit = {
     testMethod(100)(10000)(forLoop)
     testMethod(100)(1000000)(forLoop)
     testMethod(100)(100000000)(forLoop)
     println()
    testMethod(100)(10000)(whileLoop)
    testMethod(100)(1000000)(whileLoop)
    testMethod(100)(100000000)(whileLoop)
  }
}