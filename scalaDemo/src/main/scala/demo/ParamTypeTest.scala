/*
* Created by IntelliJ IDEA.
* User: Administrator
* Date: 11-5-7
* Time: 下午8:02
*/
package demo

class ParamTypeTest[U <: RuntimeException](implicit  m: Manifest[U]){

//  @throws(m.erasure)
//  def doSomething() {
//    throw new Exception;
//  }

//  @throws(manifest[T].erasure)
//  def doOthers[T <: RuntimeException]()(implicit  m: Manifest){
//    println(m.getClass)
//     throw new RuntimeException;
//  }

}

object Fuck {
  def main(args: Array[String]): Unit = {
//    try {
//      new ParamTypeTest[RuntimeException]().doSomething;
//    } catch {
//      case e: RuntimeException => println(e.getStackTrace);
//      case e => System.exit(1)
//    }
  }
}


class TestPojo{
  def print(msg: String) = println(msg)
}
