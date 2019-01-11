package org.primetalk.scala101

sealed trait ListInt
case object NilInt extends ListInt
case class Cons(head: Int, tail: ListInt) extends ListInt

object ListInt {
  val lst = Cons(1, Cons(2, Cons(3, NilInt)))

  def head(lst: ListInt): Int = lst match {
    case NilInt => throw new IllegalArgumentException("head of Nil")
    case Cons(h, t) => h
  }

  def tail(lst: ListInt): ListInt = lst match {
    case NilInt => throw new IllegalArgumentException("tail of Nil")
    case Cons(h, t) => t
  }

//  head(lst)
//  tail(lst)
//  tail(tail(lst))
//  tail(tail(tail(lst)))

  def gen(n: Int): ListInt = {
    def go(i: Int): ListInt = {
      if (i > n)
        NilInt
      else
        Cons(i, go(i + 1))
    }

    go(1)
  }

//  gen(4)


  def sum(lst: ListInt): Int = lst match {
    case NilInt => 0
    case Cons(h, t) => sum(t) + h
  }

  def sum2[T](lst: List[T])(zero: T, plus: (T,T) => T): T = lst match {
    case Nil => zero
    case h :: t => sum2(t)(plus(zero, h), plus)
  }

  def sum3[T: Numeric](lst: List[T]): T = lst match {
    case Nil => implicitly[Numeric[T]].zero
    case h :: t => implicitly[Numeric[T]].plus(sum3(t), h)
  }

  def product(lst: ListInt): Int = lst match {
    case NilInt => 1
    case Cons(h, t) => product(t) * h
  }

  def length(lst: ListInt): Int = lst match {
    case NilInt => 0
    case Cons(h, t) => length(t) + 1
  }

  def len[T](lst: List[T]): Int= lst match {
    case Nil => 0
    case _ :: t => len(t) + 1
  }

//  sum(gen(5))
//  product(gen(5))

  type BinOp = (Int, Int) => Int

  val add: (Int, Int) => Int = _ + _
  val mul: (Int, Int) => Int = _ * _


//  add(2, 4)
//  mul(5, 6)


  def foldRight(lst: ListInt, z: Int)(f: (Int, Int) => Int) = {
    def go(l: ListInt): Int = l match {
      case NilInt => z
      case Cons(h, t) => f(go(t), h)
    }

    go(lst)
  }

//  foldRight(gen(5), 0)(add)
//  foldRight(gen(5), 1)(mul)


//  foldRight(gen(50), 0)((x: Int, y: Int) => x + 1)

  def foldLeft(lst: ListInt, z: Int)(f: (Int, Int) => Int): Int = lst match {
    case NilInt => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }

//  foldLeft(gen(50), 0)((x: Int, y: Int) => x + 1)

  def append(h: Int, lst: ListInt): ListInt =
    Cons(h, lst)

  def take(lst: ListInt, n: Int): ListInt = n match {
    case 0 => NilInt
    case _ =>
      lst match {
        case NilInt => NilInt
        case Cons(h, t) => append(h, take(t, n - 1))
      }
  }

//  take(gen(5), 3)

  def drop(lst: ListInt, n: Int): ListInt = lst match {
    case NilInt => NilInt
    case Cons(h, t) =>
      if (n <= 0)
        lst
      else
        drop(t, n - 1)
  }

//  drop(gen(5), 3)

  def headOpt(lst: ListInt): Option[Int] = lst match {
    case NilInt => None
    case Cons(h, _) => Some(h)
  }

  def get(lst: ListInt, n: Int): Option[Int] = {
    val lst1 = drop(lst, n - 1)
    headOpt(lst1)
  }

//  get(gen(5), 3)


}