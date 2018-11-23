package org.primetalk.scala101

package object factorial {

  def factorial: Int => Int = n => n match {
    case 0 => 1
    case _ => n * factorial(n-1)
  }

  def sumAr(start: Int, step: Int, end: Int): Int =
    ((end - start)/step + 1) * (start + end) / 2

  def ar(start: Int, step: Int, end: Int): List[Int] =
    if(start > end) List()
    else start :: ar(start + step, step, end)

  def sumAr2(start: Int, step: Int, end: Int): Int =
    ar(start, step, end).sum

//  ar(1, 5, 101)
//  sumAr(1, 5, 101)
//  ar(1, 5, 101).sum

  def f2(n: Int): Int = {
    def go(accum: Int, i: Int): Int = {
      if(i > n) accum
      else go(accum * i, i + 1)
    }
    go(1, 1)
  }

  /*
  f 0 = 1
  f 1 = 1
  f n = f(n-1) + f(n-2)
  */
  // O(n)
  def fibonacci(n: Int): Int = {
    @annotation.tailrec
    def fibo(do2: Int, do1:Int, i: Int, n: Int): Int =
      if (i == n) do1 + do2
      else {
        fibo(do1, do1 + do2, i + 1, n)
      }
    if(n == 0 || n == 1)
      1
    else
      fibo(1,1,2,n)
  }

  // O(n^2)
  //sumFib(n:Int): Int
  //  (0 to 10).map(n => (n, fibonacci(n)))
//  (0 to 10).toList

  def fibonacciAll(n: Int): List[Int] = {
    @annotation.tailrec
    def fibo(do2: Int, do1:Int, i: Int, n: Int, accum: List[Int]): List[Int] =
      if (i == n) (do1 + do2) :: accum
      else {
        val fn = do1 + do2
        val lst2 = fn :: accum
        fibo(do1, do1 + do2, i + 1, n, lst2)
      }
    if(n == 0 || n == 1)
      List(1,1)
    else
      fibo(1,1,2,n, List(1,1)).reverse
  }
//  fibonacciAll(10)
  /** O(n) */
  def sumFib(n: Int): Int =
    fibonacciAll(n).sum


}
