/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-5
 * Time: 上午1:06
 */
package monad

sealed abstract class IOAction[+A] extends Function1[WorldState, (WorldState, A)] {
  def map[B](f: A => B): IOAction[B] = flatMap {
    x => IOAction.unit(f(x))
  }

  def flatMap[B](f: A => IOAction[B]): IOAction[B] = new ChainedAction(this, f)

  private class ChainedAction[+A, B](action1: IOAction[B], f: B => IOAction[A]) extends IOAction[A] {
    def apply(state1: WorldState) = {
      val (state2, intermediateResult) = action1(state1);
      val action2 = f(intermediateResult)
      action2(state2)
    }
  }

  def >>[B](next: => IOAction[B]): IOAction[B] =
    for {
      _ <- this;
      second <- next
    } yield second

  //  def >>[B](next: => IOAction[B]): IOAction[B] = {
  //    this.flatMap{
  //      e =>  next map { e1 => e1 }
  //    }
  //  }

  def <<[B](next: => IOAction[B]): IOAction[A] =
    for {
      first <- this;
      _ <- next
    } yield first

  def filter(p: A => Boolean, msg: String): IOAction[A] = flatMap {
    x =>
      if (p(x)) IOAction.unit(x)
      else IOAction.fail(msg)
  }

  def filter(p: A => Boolean): IOAction[A] = filter(p, "Filter mismatch")

  private class HandlingAction[+A](action: IOAction[A], handler: Exception => IOAction[A]) extends IOAction[A] {
    def apply(state: WorldState) = {
      try {
        action(state)
      } catch {
        case e: Exception => handler(e)(state)
      }
    }
  }

  def onError[B >: A](handler: Exception => IOAction[B]): IOAction[B] = new HandlingAction(this, handler)

  def or[B >: A](alternative: IOAction[B]): IOAction[B] = this onError {
    ex => alternative
  }
}


object IOAction {

  private class SimpleAction[+A](expression: => A) extends IOAction[A] {
    def apply(state: WorldState) =
      (state.nextState, expression)
  }

  def apply[A](expression: => A): IOAction[A] = new SimpleAction(expression)

  private class UnitAction[+A](value: A) extends IOAction[A] {
    def apply(state: WorldState) = (state, value)
  }

  def unit[A](value: A): IOAction[A] = new UnitAction(value)

  private class FailureAction(e: Exception) extends IOAction[Nothing] {
    def apply(state: WorldState) = throw e
  }

  private class UserException(msg: String) extends Exception(msg)

  def fail(msg: String) = ioError(new UserException(msg))

  def ioError[A](e: Exception): IOAction[A] = new FailureAction(e)


}

sealed trait WorldState {
  def nextState: WorldState
}

abstract class IOApplication {

  private class WorldStateImpl(id: BigInt)    extends WorldState {
    def nextState = new WorldStateImpl(id + 1)
  }

  final def main(args: Array[String]): Unit = {
    val ioaction = iomain(args)
    ioaction(new WorldStateImpl(0));
  }

  def iomain(args: Array[String]): IOAction[_]
}
