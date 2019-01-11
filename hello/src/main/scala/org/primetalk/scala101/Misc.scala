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
  inputLst
  sumSame(inputLst, inputLst.head)

  sumSame(2 :: 2 :: Nil, 1)

  Seq(1,2).sorted
}
