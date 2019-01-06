package org.primetalk.scala101

object Sorting {

  def quickSort(c: Seq[Int]): Seq[Int] = {
    val len = c.size
    if(len <= 1)
      c
    else {
      val i = len / 2
      val pivot = c(i)
      val lessThanPivot = c.filter(_ < pivot)
      val greaterThanPivot = c.filter(_ > pivot)
      val equalToPivot = c.filter(_ == pivot)

      val l1 = quickSort(lessThanPivot)
      val g1 = quickSort(greaterThanPivot)
      l1 ++ equalToPivot ++ g1
    }
  }

  val s = Seq(5,6,32,7,6,23,6, 10)

  s.partition(_ < 10)

  quickSort(s)





  def mergeSort(c: List[Int]): List[Int] = {

    // PRE: l1, l2 - sorted
    // POST: result - sorted l1.size + l2.size == result.size

    def merge(l1: List[Int], l2: List[Int], result: List[Int] = Nil): List[Int] = l1 match {
      case Nil => (l2 reverse_::: result).reverse
      case h1 :: t1 => l2 match {
        case Nil => (l1 reverse_::: result).reverse
        case h2 :: t2 =>
          if(h1 < h2)
            merge(t1, l2,h1 :: result)
          else
            merge(l1, t2, h2 :: result)
      }
    }
    val len = c.size
    if(len <= 1)
      c
    else {
      val i = len / 2
      val beforeI = c.take(i)
      val afterI = c.drop(i)

      val l1 = mergeSort(beforeI)
      val g1 = mergeSort(afterI)
      merge(l1, g1)
    }
  }

  mergeSort(s.toList)


  val a: Char = 'a'
  val str: String = "a string"
  val l: Long = 13462457567L
  val i: Int = l.toInt

  i


  (-1).abs
  (Int.MinValue.toLong).abs

  (Int.MinValue.toLong).abs.toInt



  BigDecimal(2147483648L)*BigDecimal(2147483648L)*BigDecimal(2147483648L)*BigDecimal(2147483648L)


  case class Complex(re: Double, im: Double)
  object ComplexNumeric extends Numeric[Complex] {
    override def plus(x: Complex, y: Complex): Complex =
      Complex(x.re + y.re, x.im + y.im)

    override def minus(x: Complex, y: Complex): Complex = ???

    override def times(x: Complex, y: Complex): Complex = ???

    override def negate(x: Complex): Complex = ???

    override def fromInt(x: Int): Complex = Complex(x, 0)

    override def toInt(x: Complex): Int = x.re.toInt

    override def toLong(x: Complex): Long = ???

    override def toFloat(x: Complex): Float = x.re.toFloat

    override def toDouble(x: Complex): Double = x.re

    override def compare(x: Complex, y: Complex): Int = ???
  }
}
