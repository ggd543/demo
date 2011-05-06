package demo

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-12-6
 * Time: 0:53:39
 * To change this template use File | Settings | File Templates.
 */

package P1 {
  package P2 {
    package P3{
      private class C31

      class C31_1 private()
      
      class C31_2 private(){
        def this(s: String) = this()
        private def this(i: Int) = this()
      }

      protected class C32
      
      class C33{
        new C31()
//        new C31_1() // error: constructor C31_1 cannot be accessed in class C33
        new C31_2(""); // OK
//        new C31_2(2) // error: compilation error
      }

      private[P2] class C34
    }//P3
    
    class C21{
//      new P3.C31()  // error: compilation error
      
    }

//    class C22 extends P3.C31 // error: class C31 cannot be accessed in package demo.P1.P2.P3

    class C23 extends P3.C33
    
  }
}

object SC2 {
  def f2() = 2
}

//class SC11 extends SC2  // compilation error