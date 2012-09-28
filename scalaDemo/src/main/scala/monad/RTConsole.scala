/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-5
 * Time: 上午12:37
 */
package monad


object RTConsole_v1 {
  def getString(state: WorldState_v1) =
    (state.nextState, Console.readLine)

  def putString(state: WorldState_v1, s: String) =
    (state.nextState, Console.print(s))
}


//file RTConsole.scala
object RTConsole_v2 {
  def getString = {
    state: WorldState_v2 => (state.nextState, Console.readLine)
  }

  def putString(s: String) = {
    state: WorldState_v2 => (state.nextState, Console.print(s))
  }
}


//file RTConsole.scala
object RTConsole_v3 {
  def getString = IOAction_v3(Console.readLine)

  def putString(s: String) = IOAction_v3(Console.print(s))
}


object RTConsole_v4 {
  def getString = IOAction_v4(Console.readLine)

  def putString(s: String) = IOAction_v4(Console.print(s))
}

//file RTConsole.scala
object RTConsole {
  def getString = IOAction(Console.readLine)

  def putString(s: String) =
    IOAction(Console.print(s))

  def putLine(s: String) =
    IOAction(Console.println(s))
}

object HelloWorld extends IOApplication {

  import IOAction._
  import RTConsole._

  def sayHello(n: String) = n match {
    case "Bob" => putLine("Hello, Bob")
    case "Chuck" => putLine("Hey, Chuck")
    case "Sarah" => putLine("Helloooo, Sarah")
    case _ => fail("match exception")
  }

  def ask(q: String) = putString(q) >> getString

  def processString(s: String) = s match {
    case "quit" => putLine("Catch ya later")
    case _ => (sayHello(s) or
      putLine(s + ", I don't know you.")) >> loop
  }

  val loop: IOAction[Unit] =
    for {
      name <- ask("What's your name? ");
      _ <- processString(name)
    } yield ()

  def iomain(args: Array[String]) = {
    putLine("This is an example of the IO monad.") >>
      putLine("Enter a name or 'quit'") >>
      loop
  }
}