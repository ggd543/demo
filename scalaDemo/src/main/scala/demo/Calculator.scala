//package demo
//
//import demo.Calculator.TokenParser
//import collection.mutable.Stack
//
///*
// * Created by IntelliJ IDEA.
// * User: Administrator
// * Date: 11-11-10
// * Time: 下午11:32
// */
//object Calculator {
//
//  class TokenParser(val source: String) {
//
//    private var pos = 0
//
//    def nextToken = {
//      // TODO
//    }
//
//  }
//
//  private def compute(operand1: String, op: String, operand2: String): Double = {
//    val d1 = operand1.toDouble
//    val d2 = operand2.toDouble
//    op match {
//      case "+" => d1 + d2
//      case "-" => d1 - d2
//      case "*" => d1 * d2
//      case "/" => d1 / d2
//    }
//  }
//
//
//  def read(expr: String): Double = {
//    val parser = new TokenParser(expr)
//    val opStack = new Stack[String]
//    val operandStack = new Stack[String]
//    var token = parse.nextToken
//    while (token != null) {
//      token match {
//        case "(" => opStack push token
//        case ")" =>
//           //TODO
//        case "*" | "/" =>
//         opStack push token
//      case "+" | "-" =>
//        //TODO
//         val operand2 = operandStack.pop()
//          val operand1 = operandStack.pop()
//          val tmp = compute(operand1, token, operand2)
//          operandStack push tmp
//        opStack push token
//      case _ =>
//        operandStack push token
//    }
//    token = parse.nextToken
//  }
//
//  return operandStack.pop
//}
//
//
//}