package org.primetalk.scala101

sealed trait TreeMap[K, +V] {

  def apply(k: K)(implicit K: Ordering[K]): V =
    get(k).getOrElse(throw new IllegalArgumentException(s"$k not found"))

  def get(k: K)(implicit K: Ordering[K]): Option[V]

  def remove(k: K)(implicit K: Ordering[K]): TreeMap[K,V]

  def updated[VV >: V](k: K, v: VV)(implicit K: Ordering[K]): TreeMap[K,V]

  def toSeq: Seq[(K,V)]

  def addAll[VV >: V](other: TreeMap[K, VV])(implicit K: Ordering[K]): TreeMap[K, V] =
    addSeq(other.toSeq)

  def addSeq[VV >: V](seq: Seq[(K, VV)])(implicit K: Ordering[K]): TreeMap[K,V] =
    seq.foldLeft(this: TreeMap[K, V]){ case (map, (k,v)) => map.updated(k,v)}

  def mapValues[VV](f: V => VV): TreeMap[K, VV] = ???

  def map[KK, VV](f: (K,V) => (KK, VV) ): TreeMap[KK, VV] = ???
}

case class TreeMapNode[K, +V](left: TreeMap[K, V], key: K, value: V, right: TreeMap[K, V]) extends TreeMap[K,V] {
  override def get(k: K)(implicit K: Ordering[K]): Option[V] = {
    val cmp: Int = K.compare(k, key)
    if (cmp == 0) Some(value)
    else if (cmp < 0) left.get(k)
    else right.get(k)
  }

  override def remove(k: K)(implicit K: Ordering[K]): TreeMap[K, V] = {
    val cmp: Int = K.compare(k, key)
    if (cmp == 0) left.addAll(right)
    else if (cmp < 0) left.remove(k)
    else right.remove(k)
  }

  override def updated[VV >: V](k: K, v: VV)(implicit K: Ordering[K]): TreeMap[K, V] = {
    val cmp: Int = K.compare(k, key)
    (
      if (cmp == 0) TreeMapNode[K,VV](left, key,v, right)
      else if (cmp < 0) TreeMapNode[K,VV](left.updated(k, v), key,v, right)
      else TreeMapNode[K,VV](left, key,v, right.updated(k, v))
    ).asInstanceOf[TreeMap[K, V]]
  }

  override def toSeq: Seq[(K, V)] =
    left.toSeq ++ right.toSeq :+ (key, value)

}

case class EmptyMap[K,V]() extends TreeMap[K, V] {
  override def get(k: K)(implicit K: Ordering[K]): Option[V] = None

  override def remove(k: K)(implicit K: Ordering[K]): TreeMap[K, V] = this

  override def updated[VV >: V](k: K, v: VV)(implicit K: Ordering[K]): TreeMap[K, V] = {
    TreeMapNode[K, VV](TreeMap.empty[K,VV], k, v, TreeMap.empty[K,VV])
      .asInstanceOf[TreeMap[K, V]]
  }

  override def toSeq: Seq[(K, V)] = Seq()

  override def addAll[VV >: V](other: TreeMap[K, VV])(implicit K: Ordering[K]): TreeMap[K, V] =
    other.asInstanceOf[TreeMap[K, V]]

}

object TreeMap {

  def empty[K, V]: TreeMap[K,V] = EmptyMap()

  def apply[K: Ordering, V](pairs: (K, V)*): TreeMap[K,V] =
    empty[K,V].addSeq(pairs)

  val m = TreeMap(
    ("Россия", "Москва"),
    "Франция" -> "Париж",
    "Финляндия" -> "Хельсинки",
    "ЮАР" -> "Кейптаун"
  )

  require(m("Россия") == "Москва")
}