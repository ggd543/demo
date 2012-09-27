/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-9
 * Time: 下午10:58
 */
package actordemo

import scala.actors.Actor._
import actors.Actor

object ActorTest5 {

  case object END

  def main(args: Array[String]): Unit = {
    val consumer =
      actor {
        println("main actor: " + Thread.currentThread())
        var done = false
        while (!done) {
          receive {
            case END => done = true
            case msg => actor {
              println(Thread.currentThread() + " - Received message! -> " + msg)
              Thread.sleep(4000)
            }
          }
        }
        println("main actor end")
      }
    consumer ! "Mares eat oats"
    consumer ! "Does eat oats"
    consumer ! "Little lambs eat ivy"
    consumer ! "Kids eat ivy too"
    consumer ! "Mares eat oats"
    consumer ! "Does eat oats"
    consumer ! "Little lambs eat ivy"
    consumer ! "Kids eat ivy too"
    consumer ! END
  }
}
