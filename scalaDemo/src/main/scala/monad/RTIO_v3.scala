/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-5
 * Time: 下午9:32
 */
package monad

//file RTIO.scala
sealed trait IOAction_v3[+A] extends Function1[WorldState_v3, (WorldState_v3, A)]

object IOAction_v3 {

  def apply[A](expression: => A): IOAction_v3[A] = new SimpleAction(expression)

  private class SimpleAction[+A](expression: => A) extends IOAction_v3[A] {
    def apply(state: WorldState_v3) = (state.nextState, expression)
  }

}

sealed trait WorldState_v3 {
  def nextState: WorldState_v3
}

abstract class IOApplication_v3 {

  private class WorldStateImpl(id: BigInt)
    extends WorldState_v3 {
    def nextState = new WorldStateImpl(id + 1)
  }

  final def main(args: Array[String]): Unit = {
    val ioAction = iomain(args)
    ioAction(new WorldStateImpl(0));
  }

  def iomain(args: Array[String]): IOAction_v3[_]
}

class HelloWorld_v3 extends IOApplication_v3 {

  import RTConsole_v3._

  def iomain(args: Array[String]) = putString("Hello world")
}
