package demo{
object MyTestApp{
  def main(args: Array[String]): Unit = {
    val myTest = new MyTest();
    myTest.printInt(4)
    myTest.printYourTest(myTest)
    myTest.fuxkTest
  }
}

class YourTest{
  override def toString = "Your Test"
  def fuxkTest = println("fuxk you")
}

object YourTest{
    implicit def myTest2YourTest = new YourTest
}

class MyTest{
  import MyTest._
  def printStr(str: String) = println(str)

   // you can't do it like `printStr(i)` unless you bring the implicit converter `MyTest.int2String`into scope
  def printInt(i: Int) = printStr(i)

  def printYourTest(obj: YourTest) = println(obj)

  def getYorTest(): YourTest = this;
}

object  MyTest {
  implicit def int2String(i: Int ): String = i.toString
  implicit def myTest2YourTest(obj: MyTest): YourTest= new YourTest
//  implicit val myTest2YourTest = (obj : MyTest) => new YourTest
}
}

//
//package service {
//
//import java.util.Date
//import java.text.SimpleDateFormat
//
//  class RichDate(str: String) {
//    def toDate(): Date = new SimpleDateFormat("yyyy-MM-dd").parse(str)
//  }
//
//  object Rest {
//  implicit def str2Date(str: String) = new RichDate(str)
//}
//
//class Rest {
//  import Rest._
//  def getDate(str: String): Date = str.toDate();
//}
//}