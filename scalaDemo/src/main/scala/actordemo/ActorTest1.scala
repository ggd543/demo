/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-10
 * Time: 上午12:02
 */
package actordemo

import scala.actors.Actor._

object ActorTest1 extends Application {
  val caller = self
  val badActor = actor {
    receive {
      case msg =>
        println(msg)
        caller ! "bbbb"
    }
  }
  badActor ! "aaaa"
  receive {
    case a: String => println(a)
  }
}