/*
* Created by IntelliJ IDEA.
* User: Administrator
* Date: 12-8-5
* Time: 上午12:19
*/
package monad

sealed abstract class IOAction_v4[+A] extends Function1[WorldState_v4, (WorldState_v4, A)] {

  def map[B](f: A => B): IOAction_v4[B] = flatMap {
    x => IOAction_v4(f(x))
  }

  def flatMap[B](f: A => IOAction_v4[B]): IOAction_v4[B] = new ChainedAction(this, f)

  private class ChainedAction[+A, B](action1: IOAction_v4[B], f: B => IOAction_v4[A]) extends IOAction_v4[A] {
    def apply(state1: WorldState_v4) = {
      val (state2, intermediateResult) = action1(state1);
      val action2 = f(intermediateResult)
      action2(state2)
    }
  }

}

object IOAction_v4 {
  def apply[A](expression: => A): IOAction_v4[A] = new SimpleAction(expression)

  private class SimpleAction[+A](expression: => A) extends IOAction_v4[A] {
    def apply(state: WorldState_v4) = (state.nextState, expression)
  }

}

// the rest remains the same
sealed trait WorldState_v4 {
  def nextState: WorldState_v4
}

abstract class IOApplication_v4 {

  private class WorldStateImpl(id: BigInt) extends WorldState_v4 {
    def nextState = new WorldStateImpl(id + 1)
  }

  final def main(args: Array[String]): Unit = {
    val ioAction = iomain(args)
    ioAction(new WorldStateImpl(0));
  }

  def iomain(args: Array[String]): IOAction_v4[_]
}

object HelloWorld_v4 extends IOApplication_v4 {

  import RTConsole_v4._

  def iomain(args: Array[String]) = {
    for {
      _ <- putString("This is an example of the IO monad.");
      _ <- putString("What's your name?");
      name <- getString;
      _ <- putString("Hello " + name)
    } yield ()
  }

}
