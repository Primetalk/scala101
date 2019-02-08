package org.primetalk.scala101

object BinaryBoard {

  val n = 11
  type Board = Array[Array[Boolean]]
  val board: Board = Array.ofDim(n, n)

  def invert(b: Board, x: Int, y: Int): Unit = {
    val rowY = b(y)
    for{ i <- 0 until n }
      rowY(i) = !rowY(i)

    for{
      j <- 0 until n
      if j != y
    }
      b(j)(x) = !b(j)(x)
  }

  def show(b: Board): String = {

    (for {
      j <- 0 until n
      row = b(j).map(if(_) '+' else 'o')
    } yield
      row.mkString(" ")
      ).mkString("\n") + "\n"
  }

  def invert2(b: Board, x1: Int, y1: Int, x2: Int, y2: Int): Unit = {
    invert(b,x1,y1)
    invert(b,x2,y2)
  }

  def invert4(b: Board, x1: Int, y1: Int, x2: Int, y2: Int): Unit = {
    invert(b,x1,y1)
    invert(b,x2,y1)
    invert(b,x1,y2)
    invert(b,x2,y2)
  }

  def main(args: Array[String]): Unit = {
    val b = board

    board(0)(0) = true

    println(show(b))
    invert4(b, 0, 0,1,1)
    println(show(b))
  }

}
