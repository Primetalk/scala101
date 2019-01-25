package org.primetalk.scala101

object ListOps {
  // List(1,2,3) (_+1) ->
  def mapInt(list: List[Int])(f: Int => Int): List[Int] =
    list match {
      case Nil => Nil
      case h::t => f(h) :: mapInt(t)(f)
    }
  // POST: forall i result(i) == f(list(i))
  def map[A, B](list: List[A])(f: A => B): List[B] =
    list match {
      case Nil => Nil
      case h::t => f(h) :: map(t)(f)
    }
  // POST: for all a in result p(a)
  def filter[A](list: List[A])(p: A => Boolean): List[A] =
    list match {
      case Nil => List()
      case h::t if p(h) =>
        h :: filter(t)(p)
      case _::t => filter(t)(p)
    }

//  val list: List[Int] = ???
//  list.foldLeft()
  @annotation.tailrec
  final def foldLeft[A, B](list: List[A], z: B)(f: (B, A) => B): B = {
    list match {
      case Nil => z
      case h::t =>
        val zz = f(z,h)
        foldLeft(t,zz)(f)
    }
  }
  // POST: forall i result(i) == f(list(i))
  def map1[A, B](list: List[A])(f: A => B): List[B] =
    foldLeft(list, List[B]()){
      (lstB, h) =>
        val b = f(h)
        b :: lstB
    }.reverse

  def append[A](list1: List[A], list2: List[A]): List[A] = {
    list1.foldRight(list2)(_ :: _)
//    foldLeft(list1.reverse, z = list2)((lst, a) => lst.::(a) )//_.::(_))
  }
  def flatten1[A](listOfLists: List[List[A]]): List[A] = listOfLists match {
    case Nil => Nil
    case h::t => append(h, flatten(t))
  }
  def flatten[A](listOfLists: List[List[A]]): List[A] = {
    listOfLists.foldRight(Nil: List[A])(append)
  }
//  flatten(List(List(0,1,2), List(5,6,7), List(8,9)))
  def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = {
    val bo: List[List[B]] = map1(list)(f)
    flatten1(bo)
  }

  def flatMap1[A, B](list: List[A])(f: A => List[B]): List[B] = {
    list
      .foldRight(Nil: List[B])(
        (a, currentList) => append(f(a), currentList)
      )
  }

}
