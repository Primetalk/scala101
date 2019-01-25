package org.primetalk.scala101

import scala.io.Source

object Day2 {

  val lines: List[String] =
    Source.fromResource("day2.txt").getLines().toList
  /**
    * pnebjqsalrkgcuzfihvtlywomu
    */
  def f(str: String, n: Int): Boolean = {
    val lst: List[Char] = str.toList
    val mapCharToChars: Map[Char, List[Char]] = lst.groupBy(c => c)
    val map2: Map[Char, Int] = mapCharToChars.mapValues(_.length)
    map2.exists(_._2 == n)
//    var b = 0
//    while(b < str.length - 1){
//      var x = b + 1
//      var k = 0
//      while(x < str.length){
//        if (str.charAt(b) == str.charAt(x))
//          k += 1
//        x += 1
//      }
//      if (k == n) return true
//      b += 1
//
//     }
//    false
  }

  def g(list: List[String]): Int = {
    list.count(f(_, n = 2)) *
      list.count(f(_, n = 3))
  }

  @annotation.tailrec
  final def diff(s1: List[Char], s2: List[Char], cnt: Int = 0): Int = (s1, s2) match {
    case (h1::t1, h2::t2) if h1 == h2 => diff(t1, t2, cnt)
    case (h1::t1, h2::t2) if h1 != h2 => diff(t1, t2, cnt + 1)
    case _ => cnt
  }

  def h(list: List[String]): String = {
    val lst = list.map(_.toList)
    val res = for{
      l1 <- lst
      l2 <- lst
//      l1 != l2
      distance = diff(l1, l2)
      if distance == 1
    } yield l1.mkString("") + "\n" + l2.mkString("")
    res.head
  }

  def main(args: Array[String]): Unit =
    println(h(lines))
}
