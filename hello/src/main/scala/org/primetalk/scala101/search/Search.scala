package org.primetalk.scala101.search

import scala.collection.immutable.Stream.Empty

object Search {

  @annotation.tailrec
  final def startsWith[T](list: List[T], sublist: List[T]): Boolean =
  {
     sublist match {
       case Nil => true
       case h::t =>
        list match {
          case h1::t1 if h == h1 =>
            startsWith(t1, t)
          case _ => false
        }
    }

  }

  /**
    * O(N*M)
    */
  @annotation.tailrec
  final def findFirst[T](list: List[T], sublist: List[T], pos: Int = 0): Option[Int] =
  {
    if (startsWith(list, sublist))
      Some(0)
    else if (list.isEmpty) None
    else findFirst(list.tail, sublist, pos + 1)
  }

  // POST:
  //   result k : list(0 .. k ) == list(length - k .. length)
  // O(M^2)
  def prefix[T](list: List[T]): Int = {
    def bo(list1: List[T], list2: List[T], k: Int): Int = {
      list2 match {
        case Nil => k
        case h::t =>
          list1 match {
            case h1::t1 if h == h1 =>
              bo(t1, t, k)
            case _ =>
              bo(list, list.drop(k + 1), k + 1)
          }
      }
    }
    list match {
      case Nil => 0
      case _   => bo(list, list.drop(1), 1)
    }
  }

  // https://scastie.scala-lang.org/oKH1A4TzSo6F71jGPVsISg
  /** O(M)! */
  def prefix2[T](list: List[T]): Vector[Int] = {
    def bo(list1: List[T], list2: List[T], k: Int): Vector[Int] = {
      list2 match {
        case Nil => ???
        case h::t =>
          list1 match {
            case h1::t1 if h == h1 =>
              bo(t1, t, k)
            case _ =>
              bo(list, list.drop(k + 1), k + 1)
          }
      }
    }
    list match {
      case Nil => ???
      case _   => bo(list, list.drop(1), 1)
    }
  }


//  def findFirst[T](list: List[T], sublist: List[T], pos: Int = 0): Option[Int] =
//  {
//    sublist.scanLeft()
//  }

}


