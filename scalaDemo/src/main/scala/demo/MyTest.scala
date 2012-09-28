package demo {

object MyTestApp {
  def main(args: Array[String]): Unit = {
    val myTest = new MyTest();
    myTest.printInt(4)
    myTest.printYourTest(myTest)
    myTest.fuxkTest
  }
}

class YourTest {
  override def toString = "Your Test"

  def fuxkTest = println("fuxk you")
}

object YourTest {
  implicit def myTest2YourTest = new YourTest
}

class MyTest {

  import MyTest._

  def printStr(str: String) = println(str)

  // you can't do it like `printStr(i)` unless you bring the implicit converter `MyTest.int2String`into scope
  def printInt(i: Int) = printStr(i)

  def printYourTest(obj: YourTest) = println(obj)

  def getYorTest(): YourTest = this;
}

object MyTest {
  implicit def int2String(i: Int): String = i.toString

  implicit def myTest2YourTest(obj: MyTest): YourTest = new YourTest

  //  implicit val myTest2YourTest = (obj : MyTest) => new YourTest
}

}


package service {

import java.util.Date
import java.text.SimpleDateFormat

class RichDate(str: String) {
  def toDate(): Date = new SimpleDateFormat("yyyy-MM-dd").parse(str)
}

class Rest {

  import Rest._

  def getDate(str: String): Date = str.toDate();
}

object Rest {
  implicit def str2Date(str: String): RichDate = new RichDate(str)
}


}

package ImplictTest {

object Main extends App {
  class PrintOps() {
    def print(implicit i: Int) = println(i);
  }

  implicit def user2PrintOps(s: String) = {
    println("use2PrintOps")
    new PrintOps
  }

  //        implicit val _int = 100;
  //  implicit def _str2int(s: String) = str2int(s);

  implicit def str2int(implicit s: String, l: List[Int]): Int = {
    println("str2int")
    Integer.parseInt(s)
  }

  implicit def getString = {
    println("getString")
    "123"
  }

  implicit def newList = {
    println("newList")
    List(2)
  }

  //  new PrintOps().print("1234");
//  "a".print(str2int("1234")("444", List(3)));
    "a".print
}

trait T

class A {
  override def toString() = "I am A";
}

object A {
  //  implicit def A2C(a: A) = {
  //    println("A.A2C");
  //    new C
  //  }
  //implicit def MA2MC(ma: M[A]) ={
  //    new M[C];
  //  }
}

class B {
  override def toString() = "I am B";
}

object B {
  implicit def B2C(b: B) = {
    println("B.B2C")
    new C
  }
}

class C {
  override def toString() = "I am C";

  def printC(c: C) = println(c);
}

object C {
  implicit def A2C(a: A) = {
    println("C.A2C");
    new C
  }

  implicit def A2M(a: A) = {
    println("C.A2M[C]")
    new M[C]
  }

    implicit def MA2MC(ma: AnyRef) = {
      new M[C];
    }

}

class D {
  def printM(m: M[C]) = println("i am M[C]");
}

object D {
  implicit def A2C(a: A) = {
    println("D.A2C");
    new C
  }
}

class M[T]

object M {
  implicit def A2M(a: A) = {
    println("M.A2M[C]");
    new M[C]
  }

  implicit def MA2MC(ma: M[A]) = {
    new M[C];
  }

}


object ABCDMain extends App {
  //  implicit def A2B(a: A) = new B
  implicit def B2C(b: B) = {
    println("B2C")
    new C
  }

  implicit def D2C(d: D) = {
    println("D2C")
    new C
  }

  new D().printC(new B) // 先调用 D2C转换函数将new D()转换成C类, 然后调用C类的printC方法，但发现传入的参数类型是B类，
  // 于是搜索当前范围有无合适的转换函数，发现B2C转换函数符合要求

  println()

  new D().printC(new A) // 先调用 D2C转换函数将new D()转换成C类, 然后调用C类的printC方法, 但发现传入的参数类型是B类，
  // 由于当前范围无合适的转换函数，故搜索object A和object C内有无合适的转换函数，最后发现object A内有合适的转换函数；
  // 如果同时在object A和object C内发现合适的转换函数，有可能导致编译错误

  println()
  //  new D().printM(new A)
  new D().printM(new M[A]) // printM需要传入类型为M[C]的参数，由于传入了类型为M[A]，又在当前范围内没有合适转换函数，
  // 因此同时在object M,object A和object C内搜索合适的转换函数，如果发现两个或以上合适的转换函数，那么有可能导致编译错误
}


}