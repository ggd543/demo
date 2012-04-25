package demo

import collection.immutable.{Stack, Queue}
import collection.mutable.HashSet


/**
 *
 * User: 刘永健
 * Date: 12-3-20
 * Time: 下午9:07
 * To change this template use File | Settings | File Templates.
 */

object Perm {
  def main(args: Array[String]): Unit = {
    test(permutation1, 5)
    println("----------------------")
    test(permutation2, 5)
  }

  private def test(f: Int => Set[Queue[Int]], n: Int) = {
    val resSet = f(n)
    println("total: " + resSet.size)
    for (res <- resSet) {
      res.foreach {
        e => print(e + " ")
      }
      println()
    }
  }


  def permutation1(n: Int): Set[Queue[Int]] = {
    val resSet = new scala.collection.mutable.HashSet[Queue[Int]]

    def perm(arrange: Queue[Int], remain: Set[Int]): Unit = {
      if (remain.isEmpty) resSet += arrange
      else {
        for (e <- remain) {
          perm(arrange + e, remain - e)
        }
      }
    }

    perm(Queue.empty[Int], 1 to n toSet)
    resSet.toSet
  }

  def permutation2(n: Int): Set[Queue[Int]] = {
    val resSet = new HashSet[Queue[Int]]
    val pathStack = new scala.collection.mutable.Stack[(Int, Int)]
    val nodeStack = new scala.collection.mutable.Stack[Int]
    val flagArray = Array.fill(n)(0)
    val elems = 1 to n
    nodeStack.pushAll(flagArray zip flagArray.indices filter (_._1 == 0) map (_._2))
    while (!nodeStack.isEmpty) {
      val i = nodeStack.pop
      flagArray(i) = 1
      pathStack.push((i, elems(i)))
      nodeStack.push(-1)
      nodeStack.pushAll(flagArray zip flagArray.indices filter (_._1 == 0) map (_._2))
      if (pathStack.size == n) {
        resSet += Queue(pathStack.map(_._2): _*)
      }
      while (!nodeStack.isEmpty && nodeStack.top == -1) {
        val (j,_)  = pathStack.pop
        flagArray(j) = 0
        nodeStack.pop
      }
    } //
    resSet.toSet
  }
}
