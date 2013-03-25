package actordemo

/**
 *
 * User: 刘永健
 * Date: 12-7-10
 * Time: 上午11:08
 * To change this template use File | Settings | File Templates.
 */


import scala.actors.Actor._

object ActorTest1 extends Application {
  val caller = self

   val badActor = actor {
    receive {
      case msg =>
        println(Thread.currentThread()+ " "+msg)
        sender ! "bbbb"
    }
  }

  badActor ! "aaaa"
  receive {
    case a: String => println(Thread.currentThread() + " " + a)

  }
}