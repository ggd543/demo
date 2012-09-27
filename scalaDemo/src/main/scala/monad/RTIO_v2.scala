/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-5
 * Time: 下午9:38
 */
package monad

//file RTIO.scala
sealed trait WorldState_v2 {
  def nextState: WorldState_v2
}

abstract class IOApplication_v2 {

  private class WorldStateImpl(id: BigInt) extends WorldState_v2 {
    def nextState = new WorldStateImpl(id + 1)
  }

  final def main(args: Array[String]): Unit = {
    val ioAction = iomain(args)
    ioAction(new WorldStateImpl(0));
  }

  def iomain(args: Array[String]): WorldState_v2 => (WorldState_v2, _)
}

//file HelloWorld.scala
class HelloWorld_v2 extends IOApplication_v2 {

  import RTConsole_v2._

  def iomain(args: Array[String]) = putString("Hello world")
}


class Evil_v2 extends IOApplication_v2 {

  import RTConsole_v2._

  def iomain(args: Array[String]) = {
    {
      startState: WorldState_v2 =>
        val (statea, a) = getString(startState)
        val (stateb, b) = getString(startState)
        assert(a == b)
        (startState, b)
    }
  }
}
