//<<<<<<< HEAD
//package actordemo
//
///**
// *
// * User: 刘永健
// * Date: 12-7-10
// * Time: 上午11:08
// * To change this template use File | Settings | File Templates.
// */
//=======
///*
// * Created by IntelliJ IDEA.
// * User: Administrator
// * Date: 12-7-10
// * Time: 上午12:02
// */
//package actordemo
//>>>>>>> d4318e488bb6c782ef1cfbebe9d3ab780fc3d33e
//
//import scala.actors.Actor._
//
//object ActorTest1 extends Application {
//  val caller = self
//<<<<<<< HEAD
//
//  val badActor = actor {
//    receive {
//      case msg =>
//        println(Thread.currentThread()+ " "+msg)
//        sender ! "bbbb"
//    }
//  }
//
//  badActor ! "aaaa"
//  receive {
//    case a: String => println(Thread.currentThread() + " " + a)
//=======
//  val badActor = actor {
//    receive {
//      case msg =>
//        println(msg)
//        caller ! "bbbb"
//    }
//  }
//  badActor ! "aaaa"
//  receive {
//    case a: String => println(a)
//>>>>>>> d4318e488bb6c782ef1cfbebe9d3ab780fc3d33e
//  }
//}