/*
* Created by IntelliJ IDEA.
* User: Administrator
* Date: 12-8-5
* Time: 下午5:54
*/
package iteratee

trait Input[+E]

case class El[E](e: E) extends Input[E]

case object Empty extends Input[Nothing]

case object EOF extends Input[Nothing]

sealed trait IterV[E, A] {
  def get = end match {
    case Done(e, _) => e
    case e => throw new RuntimeException
  }

  def flatMap[B](f: A => IterV[E, B]): IterV[E, B] = this match {
    case Done(a, e) => f(a)
    case Cont(k) => Cont(e => k(e) flatMap f)
  }

  def map[B](f: A => B): IterV[E, B] = this match {
    case Done(x, e) => Done(f(x), e)
    case Cont(k) => Cont(e => k(e) map f)
  }

  //
  //  def map[B](f: A => B): IterV[E, B] = flatMap(x => unit(f(x)))

  private def unit[B](b: B): IterV[E, B] = this match {
    case Done(_, e) => Done(b, e)
    case Cont(k) => Cont(x => k(x) unit b)
  }

  def end = this match {
    case Cont(f) => f(EOF) match {
      case Cont(ff) => Done(None, EOF);
      case e => e
    }
    case e => e
  }
}

case class Done[E, A](a: A, e: Input[E]) extends IterV[E, A]

case class Cont[E, A](f: Input[E] => IterV[E, A]) extends IterV[E, A]

object Enumerator extends App {

//  伪递归，通过创建很多个对象来代替循环
//  def enumerate[E, A]: (List[E], IterV[E, A]) => IterV[E, A] = {
//    val f2: (List[E], IterV[E, A]) => IterV[E, A] = {
//      case (Nil, i) => i
//      case (_, i@Done(_, _)) => i
//      case (x :: xs, Cont(f)) => enumerate(xs, f(El(x)))
//    }
//        println("create a new Function2 "+f2);
//    f2;
//  }

    @scala.annotation.tailrec
    def enumerate[E, A](ls: List[E], iter: IterV[E, A]):  IterV[E, A] = (ls, iter) match{
      case (Nil, i) => i
      case (_, i@Done(_, _)) => i
      case (x :: xs, Cont(f)) => enumerate[E,A](xs, f(El(x)))
    }

  def counter[A]: IterV[A, Int] = {
    def step(n: Int): Input[A] => IterV[A, Int] = {
      case El(x) => Cont(step(n + 1))
      case Empty => Cont(step(n))
      case EOF => Done(n, EOF)
    }
    Cont(step(0))
  }

  def drop[E](n: Int): IterV[E, Unit] = {
    def step: Input[E] => IterV[E, Unit] = {
      case El(x) => drop[E](n - 1)
      case Empty => Cont(step)
      case EOF => Done((), EOF)
    }
    if (n == 0) Done((), Empty) else Cont(step)
  }

  def head[E]: IterV[E, Option[E]] = {
    def step: Input[E] => IterV[E, Option[E]] = {
      case El(x) => Done(Some(x), Empty)
      case Empty => Cont(step)
      case EOF => Done(None, EOF)
    }
    Cont(step)
  }


  def doubleCounter: IterV[Int, Int] = {
    def count(n: Int): Input[Int] => IterV[Int, Int] = {
      case El(x) => if (x % 2 == 0) Cont(count(n + 1)) else Cont(count(n))
      case Empty => Cont(count(n))
      case EOF => Done(n, EOF)
    }
    Cont(count(0))
  }


  val list = (1 to 10).toList;
  enumerate(list, enumerate(list, counter[Int])) match {
    case Done(e, rest) => println(e)
    case Cont(f) => println("total : " + f(EOF).asInstanceOf[Done[_, _]].a)
  }

  enumerate(list, doubleCounter).end match {
    case Done(e, _) => println("total : " + e)
    case _ => throw new RuntimeException()
  }

  println("head: " + enumerate(Nil, head[Int]).get)
  println("head: " + enumerate(list, head[Int]).get)
  println("drop: " + enumerate(list, drop[Int](1)).get)


  def drop1Keep1[E]: IterV[E, Option[E]] = for {
    _ <- drop(1)
    x <- head
  } yield x

  def _drop1Keep1[E]: IterV[E, Option[E]] = drop(1) flatMap {
    y => for (x <- head) yield x
  }

  def __drop1Keep1[E]: IterV[E, Option[E]] = drop(1) flatMap {
    y => head map {
      x => x
    }
  }

  println("-------------")
  println(enumerate(list, drop1Keep1[Int]).get)
  println(enumerate(List(3), drop1Keep1[Int]))
  println(enumerate(List(3), drop1Keep1[Int]).get)
  println(enumerate(list, drop1Keep1[Int]).get)
  println(enumerate(List(3, 4), drop1Keep1[Int]).get)
  println(enumerate(List(3, 4, 5), drop1Keep1[Int]).get)

  println("=====")
  println(enumerate(Nil, drop1Keep1[Int]).get);


}
