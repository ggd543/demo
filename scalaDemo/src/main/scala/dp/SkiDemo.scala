package dp

import io.Source

/**
 *
 * User: 刘永健
 * Date: 12-3-21
 * Time: 上午11:23
 * To change this template use File | Settings | File Templates.
 */

object SkiDemo {
  private def getInput(path: String) = {
    val is = getClass.getResourceAsStream(path)
    Source.fromInputStream(is).getLines()
  }

  def main(args: Array[String]): Unit = {
    val lines = getInput("/ski.txt")
    val dimStr = lines.next().trim.split("\\s+")
    val (n, m) = (dimStr(0).toInt, dimStr(1).toInt)
    val matrix = Array.fill(n, m)(0)
    for (i <- matrix.indices) {
      val s = lines.next.trim.split("\\s+")
      for (j <- matrix(i).indices) {
        matrix(i)(j) = s(j).toInt
      }
    }
    val (v, (x, y)) = maxLen(matrix)
    println("maxLength: " + v)
    println("x = " + x + " y = " + y)
    
  }

  private def initResMatrix(matrix: Array[Array[Int]]) = {
    val min = matrix.map(_.min).min // 挑出matrix最小的元素值
    val resMatrix = Array.fill(matrix.length, matrix(0).length)(0) // 记录matrix上每个点的最长路径长度
    // 先挑出第一级的元素
    for (i <- matrix.indices) {
      for (j <- matrix(i).indices) {
        val e = matrix(i)(j)
        if (e == min) {
          resMatrix(i)(j) = 1
        }
      }
    }
    resMatrix
  }


  def maxLen(matrix: Array[Array[Int]]): (Int, (Int, Int)) = {
    var isEnd = false // 迭代是否结束
    val resMatrix = initResMatrix(matrix)

    def calcMaxlen(i: Int, j: Int, p: Int, q: Int): (Boolean, Int) = {
      val n = matrix.length
      val m = matrix(0).length
      if (p >= 0 && p < n && q >= 0 && q < m) {
        val e = matrix(i)(j)
        val u = matrix(p)(q)
        if (u < e) {
          if (resMatrix(p)(q) > 0)
            (true, resMatrix(p)(q) + 1)
          else
            (false, 1)
        } else {
          (true, 1)
        }
      } else {
        (true, 1)
      }
    }

    while (resMatrix.exists(_.exists(_ == 0))) {
      for (i <- matrix.indices) {
        for (j <- matrix(i).indices) {
          val flag_max_array = Array.fill(4)((true, 0))
          flag_max_array(0) = calcMaxlen(i, j, i - 1, j)
          flag_max_array(1) = calcMaxlen(i, j, i, j - 1)
          flag_max_array(2) = calcMaxlen(i, j, i + 1, j)
          flag_max_array(3) = calcMaxlen(i, j, i, j + 1)
          if (flag_max_array.forall(_._1 == true)) {
            resMatrix(i)(j) = flag_max_array.map(_._2).max
          }
        } //for
      } // for
    } //while
    printMatrix(resMatrix)
    getMaxValueAndPoint(resMatrix)
  }

  private def getMaxValueAndPoint(resMatrix: Array[Array[Int]]) = {
    val optimal = resMatrix.map(_.zipWithIndex).zipWithIndex.map(e => (e._1.max, e._2)).max
    (optimal._1._1, (optimal._2, optimal._1._2))
  }
  
  def printMatrix(resMatrix: Array[Array[Int]])= {
    println("solution matrix: ")
    for (array <- resMatrix ){
      for (e <- array){
        print(e +" ")
      }
      println
    }
  }
}
