package org.primetalk.scala101

sealed trait Either[+A, +B]

case class Left [+A](value: A) extends Either[A, Nothing]
case class Right[+B](value: B) extends Either[Nothing, B]
//sealed trait MyOption[+T]
//case object MyNone extends MyOption[Nothing]
//case class MySome[T](value: T) extends MyOption[T]
object Either {
  def map[A, B, C](e: Either[A, B])(f: B => C): Either[A, C] = ???
  def fold[A, B, C](e: Either[A, B])(f: A => C)(g: B => C): C = ???
  def flatMap[A, B, C](e: Either[A, B])(f: B => Either[A, C]): Either[A, C] = ???
}
