package demo {

object MyTestApp {
  def main(args: Array[String]): Unit = {
    val myTest = new MyTest();
    myTest.printInt(4)
    myTest.printYourTest(new MyTest())
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

  implicit def myTest2YourTest(obj: MyTest): YourTest = {
    println("MyTest.myTest2YourTest ... ")
    new YourTest
  }


//    implicit val myTest2YourTest = (obj : MyTest) => new YourTest
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
}
