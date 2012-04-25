package demo

import annotation.tailrec

/**
 *
 * User: 刘永健
 * Date: 12-2-11
 * Time: 下午8:46
 * To change this template use File | Settings | File Templates.
 */

class Approx {
  def isGoodEnough(guess: Double): Boolean =
    if (guess < 1) true
    else false

  def improve(guess: Double): Double = guess - 1

  @tailrec
  final def approximate(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else approximate(improve(guess))

  def approximateLoop(initialGuess: Double): Double = {
    var guess = initialGuess
    while (!isGoodEnough(guess))
      guess = improve(guess)
    guess
  }
}

object TailRecDemo {
  val app = new Approx()

  def main(args: Array[String]) = {
    println(System.getProperty("java.class.path"))
    recursive(1)
    iterate(1)
    recursive(10)
    iterate(10)
    recursive(100)
    iterate(100)
  }

  def recursive(n: Int) = {
    val start = java.lang.System.currentTimeMillis()
    for (i <- 0 to 10000000) {
      app.approximate(n)
    }
    println(java.lang.System.currentTimeMillis() - start)
  }

  def iterate(n: Int) = {
    val start = java.lang.System.currentTimeMillis()
    for (i <- 0 to 10000000) {
      app.approximateLoop(n)
    }
    println(java.lang.System.currentTimeMillis() - start)
  }

}
