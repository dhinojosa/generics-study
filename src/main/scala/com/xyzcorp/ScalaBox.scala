package com.xyzcorp


class ScalaBox[+E](val e: E) {
  def map[U](f: E => U): ScalaBox[U]
     = new ScalaBox(f.apply(e))
}

object ScalaCollectionUtil {
  def myMax[A <: Comparable[A]](list: List[A]): Option[A] = {
    var result: A = list.head
    if (list.isEmpty) None
    else {
      for (item <- list.tail) {
        if (item.compareTo(result) > 0) result = item
      }
      Some(result)
    }
  }

  def myMax2[A](list: List[A])(implicit ev: A => Ordered[A]): Option[A] = {
    var result: A = list.head
    if (list.isEmpty) None
    else {
      for (item <- list.tail) {
        if (item > result) result = item
      }
      Some(result)
    }
  }

  def myMax2[A : Ordering](list: List[A]): Option[A] = {
    if (list.isEmpty) None else Some(list.max)
  }
}
