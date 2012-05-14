package demo

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-12-5
 * Time: 23:22:27
 * To change this template use File | Settings | File Templates.
 */

package P1 {

package P11 {

package P111 {

class PC_111 {
  private def print_1() = println("P1.P11.P111.PC_111.print_1()")

  protected def print_2() = println("P1.P11.P111.PC_111.print_2()")

  def print_3() = println("P1.P11.P111.PC_111.print_3()")

  PC_111.ok

  //  private[PC_112] def _show_1() = println("to PC_112")  // error: PC_112 is not an enclosing class
  private[P111] def p111_print_1() = println("P1.P11.P111.PC_111.p111_print_1()")

  //   private[P12] def _show_2() = println("P1.P11.P111.PC_111.p111_print_1()") // error:P12 is not an enclosing class

  private[P1] def P1_P11_print_1() = println("P1_P11.P1_P11_print_1()")

}

object PC_111 {
  new PC_111().print_1(); //ok
  new PC_111().print_2();

  //ok

  private def ok() = "ok"

}

class PC_112 {
  // def show_1() = new PC_111().print_1(); // compilation error
  //        def show_2() = new PC_111().print_2();  // compilation error
  def show_3() = new PC_111().print_3();

  def p111_print_1() = new PC_111().p111_print_1();

  def p1_p111_print_1() = new PC_111().P1_P11_print_1();
}

class PC_113 extends PC_111 {
  //    def say_1() = super.print_1();  // compilation error
  def say_2() = super.print_2();

  def say_3() = super.print_3()
}

}

//P111

}

//P11

package P12 {

}

//P12

}

//P1

class SC1 {
}

object SC1 {
  def f1() = 1
}


