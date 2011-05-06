package actordemo

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-1-22
 * Time: 下午3:07
 * To change this template use File | Settings | File Templates.
 */

import scala.actors._
import Actor._



object NewMain {

  def main(args: Array[String]): Unit = {
    var startTime : Long = 0
    val caller = self

    val engrossedActor = actor {
      println("Number of messages received so far? "  + mailboxSize)
      caller !? "send"

      Thread.sleep(3000)
      println("Number os messages received while I was busy? " + mailboxSize)
      receive {
        case msg =>
          val receivedTime= System.currentTimeMillis() - startTime
          println("Received message " + msg + " after " + receivedTime + " ms")
      }
      caller ! "received"
    }

    receive { case e =>  println(e)}
    println(" sending message ")
    startTime = System.currentTimeMillis()

    engrossedActor ! "Hello buddy"
    val endTime = System.currentTimeMillis() - startTime
    printf("Took less than %dms to send message\n", endTime)
    receive {
      case e =>  println(e)
    }
  }
}