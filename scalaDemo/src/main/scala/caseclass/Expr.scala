package caseclass

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-1-28
 * Time: 上午12:05
 * To change this template use File | Settings | File Templates.
 */

abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class Binary(operator: String, arg1: Expr, arg2: Expr) extends Expr


//-----------------------------------------
class Toy(name: String)

abstract class Person

case class Children(id: Int, toy: Toy)

object Email {
  //def apply(user: String, domain: String) = user+"@"+domain

  def unapply(s: String): Option[(String, String)] = {
    println("unapply");
    var parts = s split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }

  var e1 = "yliu@kalengo.com"

  def func(e1: Any): Unit = {
    e1 match {
      case Email(u, d) => println("This is an valid email, where the user part is %s and the domain part is %s".format(u, d));
      case _ => println("Not an emaiL")
    }
  }
}

