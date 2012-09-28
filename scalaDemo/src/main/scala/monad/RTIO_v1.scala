/*
* Created by IntelliJ IDEA.
* User: Administrator
* Date: 12-8-5
* Time: 下午9:36
*/
package monad


//file RTIO.scala
sealed trait WorldState_v1 {
  def nextState: WorldState_v1
}

abstract class IOApplication_v1 {

  private class WorldStateImpl(id: BigInt) extends WorldState_v1 {
    def nextState = new WorldStateImpl(id + 1)
  }

  final def main(args: Array[String]): Unit = {
    iomain(args, new WorldStateImpl(0))
  }

  def iomain(args: Array[String], startState: WorldState_v1): (WorldState_v1, _)
}

class HelloWorld_v1 extends IOApplication_v1 {

  import RTConsole_v1._

  def iomain(args: Array[String], startState: WorldState_v1) = putString(startState, "Hello world")
}

class Evil_v1 extends IOApplication_v1 {

  import RTConsole_v1._

  def iomain(args: Array[String], startState: WorldState_v1) = {
    val (stateA, a) = getString(startState)
    val (stateB, b) = getString(startState)
    assert(a == b)
    (startState, b)
  }
}