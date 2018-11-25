package org.primetalk.scala101

sealed trait OptionInt
case object NoneInt extends OptionInt
case class SomeInt(i: Int) extends OptionInt
