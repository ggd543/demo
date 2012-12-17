package actordemo

import scala.actors.Actor._

/**
 * calculate a perfect number whose factors add up to twice the number.
 */
object MultiCalcFor {

  def sumOfFactorsInRange(lower: Long, upper: Long, number: Long) = {
    (0L /: (lower to upper)) {
      (sum, i) => if (number % i == 0) sum + i else sum
    }
  }

  def isPerfectConcurrent(candidate: Long) = {
    val RANGE = 1000000
    val numberOfPartitions = (candidate.toDouble / RANGE).ceil.toLong
    val caller = self
    // calculate each part in seperate actor
    for (i <- 0L until numberOfPartitions) {
      val lower = i * RANGE + 1
      val upper = candidate min (i + 1) * RANGE
      actor{
        caller ! sumOfFactorsInRange(lower, upper, candidate)
      }
    }

    val sum = (0L /: (0L until numberOfPartitions)) {
//      react{}
      (partialSum, i) => react{
        case sumInRange: Long =>
          println(i+ " sumInRange: "+sumInRange)
          partialSum + sumInRange
      } // 串行接收
    }
    println("finish computing")
    2 * candidate == sum
  }

  def main(args: Array[String]): Unit = {
    //    println("6 is perfect? " + isPerfectConcurrent(6))
    val start = System.currentTimeMillis
    println("933550336 is perfect? " + isPerfectConcurrent(933550336))
    val end = System.currentTimeMillis
    println("time : " + (end - start) + " ms asynchronously")

    val start2 = System.currentTimeMillis
    println("933550336 is perfect? " + isPerfectSync(933550336))
    val end2 = System.currentTimeMillis
    println("time : " + (end2 - start2) + " ms synchronously")
    //    println("1000000 is perfect? " + isPerfectConcurrent(1000000))
  }

  def isPerfectSync(candidate: Long): Boolean = {
    val sum  = (0L /: (1L to candidate)) {
      (sum , i ) =>  if (candidate % i == 0) sum + i else sum
    }
    sum == 2 * candidate
  }
}