package org.primetalk.scala101

sealed trait Tree[+T]
case object Empty extends Tree[Nothing]
case class Branch[+T](left: Tree[T], value: T, right: Tree[T]) extends Tree[T]

object Tree {

  def sum[T: Numeric](tree: Tree[T]): T = tree match {
    case Empty => implicitly[Numeric[T]].zero
    case Branch(l,v,r) =>
      val N = implicitly[Numeric[T]]
      N.plus(sum(l), N.plus(sum(r), v))
  }

  def size[T](tree: Tree[T]): Int = tree match {
    case Empty => 0
    case Branch(l,_,r) =>
      size(l) + size(r) + 1
  }

  def fold[T, B](tree: Tree[T], b: B)(f: (B,T,B) => B): B = tree match {
    case Empty => b
    case Branch(l,v,r) =>
      f(fold(l,b)(f),v,fold(r,b)(f))
  }

}
