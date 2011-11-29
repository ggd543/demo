package demo

import tools.util.StringOps

object PostAndApple {
  def main(args: Array[String]): Unit = {
    val apple = new Apple
    val posT = new PosT

//    apple.say(posT)
    apple.say(apple)
    StringOps
    Predef
  }
}

class Con1[A]

class Con2[A, B]

object Con2{
  implicit def toCon2Apple : Con2[String, Con1[Apple]] = {
     println("toCon2Apple")
    new  Con2[String, Con1[Apple]]
  }
}

class PosT
//
//object PosT {
//  implicit def here: Con2[String, Con1[PosT]] = {
//    println("PosT implicit")
//    new Con2[String, Con1[PosT]]
//  }
//}

class Apple {
  def say[T, TT](t: T)(implicit m: Con2[TT, Con1[T]]): Int = {
    0
  }
}

object Apple {
//  implicit def here: Con2[String, Con1[PosT]] = {
//    println("Apple implicit")
//    new Con2[String, Con1[PosT]]
//  }
//  implicit def there: Con2[String, Con1[Apple]] = {
//    println("Apple implicit to Con2[String, Con1[Apple]] ")
//    new Con2[String, Con1[Apple]]
//  }
}


