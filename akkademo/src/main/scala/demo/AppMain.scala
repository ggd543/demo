package demo

/**
 *
 * User: 刘永健
 * Date: 12-3-7
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */

class SuperApp extends App{
  println("hello")
}

object  AppMain extends SuperApp {
   println("world")
}
