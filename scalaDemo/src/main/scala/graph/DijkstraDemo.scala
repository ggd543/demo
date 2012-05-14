package graph


import collection.immutable.Queue
import collection.mutable.{HashMap, HashSet}
import annotation.tailrec
import io.Source
import java.io.{InputStream, File}


/**
 *
 * User: 刘永健
 * Date: 12-3-20
 * Time: 上午9:35
 * To change this template use File | Settings | File Templates.
 */

object DijkstraDemo {

  def readGraph(is: InputStream) = {
    Source.fromInputStream(is).getLines()
  }

  def main(args: Array[String]): Unit = {
    //    val line = """(1,2 ) -> (3 ,4) , (5, 6) , (2,7) """
    val is = getClass.getResourceAsStream("/graph.txt")
    readGraph(is).foreach {
      line =>
        val (p1, p2) = parsePointLink(line)
        println(p1)
        p2.foreach(println _)
        println()
    }

    val (left, right) = fun(1 to 9 toList)
    println(left)
    println(right)
  }

  private def traverse(graph: Map[Point, Seq[Point]], from: Point, to: Point) = {
    val pathStack = new scala.collection.mutable.Stack[Point]
    val nodeStack = new scala.collection.mutable.Stack[Point]
    val resSet = new HashSet[Queue[Point]]()
    pathStack.push(from)
    nodeStack.pushAll(graph(from))
    while (!nodeStack.isEmpty) {
         // todo
    }
    resSet.toSet
  }

  def fun(list: List[Int]): (List[Int], List[Int]) = {
    @tailrec
    def _fun(resList: (List[Int], List[Int]), list: List[Int]): (List[Int], List[Int]) = list match {
      case Nil => resList
      case a :: Nil => (resList._1 ::: List(a), resList._2 ::: Nil)
      case a :: b :: rest => _fun((resList._1 ::: List(a), resList._2 ::: List(b)), rest)
    }
    _fun((Nil, Nil), list)
  }

  def parsePointLink(s: String): (Point, Seq[Point]) = {
    val tmp = s.split("->")
    val p1 = toPoint(tmp(0))
    val p2 = tmp(1).split(",").grouped(2).map(e => toPoint(e.mkString(",")))
    (p1, p2.toSeq)
  }

  private def toPoint(s: String): Point = {
    val sa = s.trim.split("[)(,]")
    Point(sa(1).trim.toInt, sa(2).trim.toInt)
  }

  case class Point(x: Int, y: Int)

  case class Node(origin: Point, nears: Map[Point, Int]) {
    override def equals(obj: Any) = obj match {
      case that: Node => this.origin == that.origin
      case _ => false
    }
  }

  class UnDirectedGraph(nodes: Seq[Node]) {

    def allNodes = nodes

    private def initCalcMap(to: Node) = {
      val calcMap = new HashMap[Node, (Set[Node], Int)]
      for (node <- allNodes) {
        val v = if (node == to) 0 else node.nears.getOrElse(to.origin, Int.MaxValue / 2)
        calcMap += (node ->(Set(to), v))
      }
      calcMap
    }

    def getSolutions(map: HashMap[Node, (Set[Node], Int)], from: Node, to: Node): (Int, Set[Queue[DijkstraDemo.Node]]) = {
      val totalValue = map(from)._2
      throw new UnsupportedOperationException
    }

    def calcShortPath(from: Node, to: Node): (Int, Set[Queue[Node]]) = {
      val S = new HashSet[Node]()
      val U = new HashSet[Node]()
      val (s, u) = allNodes.partition(_ == to)
      S ++= s
      U ++= u
      // 初始化 计算表
      val calcMap = initCalcMap(to)
      while (!U.isEmpty) {

      }
      getSolutions(calcMap, from, to)
    }

    private def getNode(point: Point) = {
      allNodes.find(_.origin == point)
    }

    def calcShortPath(from: Point, to: Point): (Int, Set[Queue[Point]]) = {
      getNode(from) match {
        case Some(fromNode) =>
          getNode(to) match {
            case Some(toNode) =>
              val (value, solutions) = calcShortPath(fromNode, toNode)
              (value, solutions.map(nodePath => nodePath.map(node => node.origin)))
            case _ => throw new NoPointException("Not found " + to)
          }
        case _ => throw new NoPointException("Not found " + from)
      }
    }

  }

  class NoSolutionException(msg: String) extends Exception(msg)

  class NoPointException(msg: String) extends Exception(msg)

}