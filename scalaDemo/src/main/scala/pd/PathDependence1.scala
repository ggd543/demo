package pd

/**
 *
 * User: 刘永健
 * Date: 12-9-29
 * Time: 下午11:54
 * To change this template use File | Settings | File Templates.
 */
object PathDependence1 extends App {
  val cell = new AbsCell {
    type T = Int
    val init = 10
  }
  println(cell.getClass)
    println(cell.isInstanceOf[AbsCell{type T=String}]) // true
  //  val cell2: AbsCell{type T=String} = cell // compilation error

  val o1 = new Outer
  val i = new o1.Inner

  val cat1 = new Cat
  val cat2 = new Cat
  cat1.eat(new cat1.F) // 吃魚
  cat2.eat(new cat2.F)
  // 吃魚
  val cat3: cat2.F = new cat1.F

  var flip = false

  def f(): AbsCell = {
    //    flip = !flip
    if (flip) new AbsCell {
      type T = Int;
      val init = 1
    }
    else new AbsCell {
      type T = String;
      val init = "abc"
    }
  }

  def g(): AbsCell{type T = AnyVal}  = {
    new AbsCell {
      type T = AnyVal
      val init = 10
    }
  }

  //   f().set(f().get)
  val c1 = new AbsCell {
    type T = Int
    val init = 1
  }

  val c2 = new AbsCell {
    type T = Int
    val init = 2
  }

  c1.set(c2.init)
  g().set(g().init)
}

abstract class AbsCell {
  type T
  val init: T
  private var value = init

  def get: T = value

  def set(x: T) = {
    value = x
  }
}

class Food

class Fish extends Food {
  override def toString = "魚"
}

abstract class Animal {
  type F <: Food

  def eat(f: F)
}

class Cat extends Animal {
  type F = Fish

  def eat(fish: F) {
    println("吃" + fish)
  }
}


class Outer {
  private val x = 10

  class Inner {
    private val y = x + 10
  }

}