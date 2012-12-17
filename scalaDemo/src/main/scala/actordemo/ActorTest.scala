/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-18
 * Time: 上午10:13
 */
package actordemo

import scala.actors.Actor._
import actors.scheduler.ExecutorScheduler
import actors.{Actor, IScheduler}
import java.util.concurrent.{ThreadPoolExecutor, TimeUnit, SynchronousQueue}

object ActorTest {

  System.setProperty("actors.corePoolSize", "2")
  System.setProperty("actors.maxPoolSize", "4")

  val aQue = new SynchronousQueue[Runnable]();
  val bQue = new SynchronousQueue[Runnable]();

  val aScheduler = ExecutorScheduler(new ThreadPoolExecutor(1,
    1,
    60000L,
    TimeUnit.MILLISECONDS,
    aQue,
    new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy))

  //aScheduler.start()

  val bScheduler = ExecutorScheduler(new ThreadPoolExecutor(1,
    1,
    60000L,
    TimeUnit.MILLISECONDS,
    bQue,
    new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy))
  //bScheduler.start()


  def main(args: Array[String]) {
    for (i <- 1 to 3) {
      val actor = new OuterActor(i, bScheduler)
      actor.start()
    }
  }

  class OuterActor(i: Int, iScheduler: IScheduler) extends Actor {
    override def act() = {
      println("hello ,this is " + i)
      Thread.sleep(300)

      val actor = new InnerActor(i, aScheduler)
      actor.start()

      println("hello ,finish is " + i)
    }

    override final val scheduler: IScheduler = iScheduler
  }

  class InnerActor(i: Int, iScheduler: IScheduler) extends Actor {
    override def act() = {
      println("inner actor-" + i)
      Thread.sleep(300)
      println("inner finish-" + i)
    }

    override final val scheduler: IScheduler = iScheduler
  }


}
