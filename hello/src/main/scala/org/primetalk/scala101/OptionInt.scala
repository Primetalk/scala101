package org.primetalk.scala101

sealed trait OptionInt
case object NoneInt extends OptionInt
case class SomeInt(i: Int) extends OptionInt

sealed trait MyOption[+T]
case object MyNone extends MyOption[Nothing]
case class MySome[T](value: T) extends MyOption[T]

object MyOption {
  def map[A, B](opt: MyOption[A])(f: A => B): MyOption[B] = {
    opt match {
      case MyNone => MyNone
      case MySome(a) => MySome(f(a))
    }
  }

//  val o: Option[Int]
//  o.map(_ + 1)
  def flatMap[A, B](opt: MyOption[A])(f: A => MyOption[B]): MyOption[B] = {
    opt match {
      case MyNone => MyNone
      case MySome(a) => f(a)
    }
  }

  def fold[A, B](opt: MyOption[A], z: B)(f: A => B): B =
    opt match {
      case MyNone => z
      case MySome(a) => f(a)
    }
}