package ImplictTest {
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

  new D().printC(new A) // 先调用 D2C转换函数将new D()转换成C类, 然后调用C类的printC方法, 但发现传入的参数类型是A类，
  // 由于当前范围无合适的转换函数，故搜索object A和object C内有无合适的转换函数，最后发现object A内有合适的转换函数；
  // 如果同时在object A和object C内发现合适的转换函数，有可能导致编译错误

  println()
//    new D().printM(new A)
  new D().printM(new M[A]) // printM需要传入类型为M[C]的参数，由于传入了类型为M[A]，又在当前范围内没有合适转换函数，
  // 因此同时在object M,object A和object C内搜索合适的转换函数，如果发现两个或以上合适的转换函数，那么有可能导致编译错误
}

}