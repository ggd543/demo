package demo

import actors.Actor

/**
 * Created by 刘永健
 * User: 刘永健
 * Date: 11-11-4
 * Time: 下午6:41
 * To change this template use File | Settings | File Templates.
 */
object BiBao {
  def main(args: Array[String]): Unit = {
    //    test1()
    //    println
    //    test2()
    //    println
    test3()
//    test4()
  }

  def test1() {
    val fruits = Array("apple", "orange", "banana")
    val fruit: String = null;
    def printFruit = println(fruit)
    for (i <- fruits.indices) {
      val fruit = fruits(i)
      printFruit
    }
  }

  def test2() {
    val fruits = Array("apple", "orange", "banana")
    var fruit: String = null;
    def printFruit = println(fruit)
    for (i <- fruits.indices) {
      fruit = fruits(i)
      printFruit
    }
  }

  def test3() {
    val fruits = Array("apple", "orange", "banana")
    var fruit: String = null
    for (i <- fruits.indices) {
      fruit = fruits(i)
      Actor.actor {
        for (j <- 1 to 3) {
          println((i+j )+ " : " + fruit)
          Thread.sleep(5000)
        }
      }
      //      Thread.sleep(5000)
    }
  }


  def test4() {
    val nOfWorkers = 1000;
     System.setProperty("actors.corePoolSize", String.valueOf(nOfWorkers))
    for (i <- 1 to 3; val x = i; j <- 1 to 3; val y = j) Actor.actor {
      println(Thread.currentThread()+ "x = " + x + ", y =" + y);
      Thread.sleep(100000)
    }
  }

}