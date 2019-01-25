package org.primetalk.scala101

object Misc {
// https://scastie.scala-lang.org/qi9sBNCxRcGZPmh8Aw7LhQ
  def sumSame(lst: List[Int], head: Int): Int = lst match {
    case h :: h2 :: t if h == h2   => h + sumSame(h2 :: t, head)
    case h :: Nil     if h == head => h
    case Nil                       => 0
    case _ :: t                    => sumSame(t, head)
  }

  val input = "91212129"
  val inputLst = input.toCharArray.map(_ - '0').toList
//  inputLst
  sumSame(inputLst, inputLst.head)

  sumSame(2 :: 2 :: Nil, 1)

  Seq(1,2).sorted

  def divide(a: Int, b: Int): Option[Int] = {
    if(b == 0)
      None
    else
      Some(a / b)
  }

  def boo: Option[Int] = {
    for {
      a <- divide(10,0)
      b <- divide(10,2)
    } yield a * b
  }

  def divide2(a: Int, b: Int): Either[String, Int] = {
    if(b == 0)
      Left("Divide by zero")
    else
      Right(a / b)
  }
}
