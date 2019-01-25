package org.primetalk.scala101

object syntax {

  val a: Int = 1 + 1
  var b: Int = 2
  def c(i: Int, j: String)(k: Int)(z: String): Int = 3 + i
  type Matrix[A,B] = List[List[(A,B)]]

  val d: Int => String => Int = c(10, "")

  def f(a: Int): Int = a + 1
  val ff: Int => Int = a => a + 1

  a.+(9)

  val lst = List(1,2,3)
  def addOne: Int => Int = _ + 1
  val g: List[Int] = lst.map(addOne)
  val gg: List[Int] = lst map addOne
  /*
  main :: IO ()

  f :: Int -> Int
  f x = x + 1

   */

  type Age = Int

  def maxAge: Age = ???


  trait WithShow {
    def show: String = ""
  }


  class MyClass(i: Int) extends WithShow {

  }
  object MyObjectWithShow extends WithShow {

  }

  val cc = new MyClass(10)
  cc.show
  MyObjectWithShow.show
}
