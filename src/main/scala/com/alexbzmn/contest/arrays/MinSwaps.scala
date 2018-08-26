package com.alexbzmn.contest.arrays

import scala.util.Random

object MinSwaps {
  def main(args: Array[String]): Unit = {
    println(mergeSort(Array(4, 3, 1, 2)).mkString(" "))
    println(mergeSort(Array(0, 3, 5, 112, 344, -1)).mkString(" "))
    println(mergeSort(Array(4)).mkString(" "))
    println(mergeSort(Array(4, 3)).mkString(" "))
    println(mergeSort(Seq.fill(10)(Random.nextInt).toArray).mkString(" "))
  }

  def getMid(lo: Int, hi: Int): Int = {
    (lo + hi) / 2
  }

  def mergeSort(arr: Array[Int]): Array[Int] = {

    def merge(left: Array[Int], right: Array[Int]): Array[Int] = {
      var merged = Array[Int]()
      val hi = left.length + right.length

      var idxLeft = 0
      var idxRight = 0

      for (i <- 0 until hi) {
        if (idxRight == right.length ||
          idxLeft < left.length && left(idxLeft) <= right(idxRight)) {
          merged = merged :+ left(idxLeft)
          idxLeft += 1
        } else if (idxRight < right.length) {
          merged = merged :+ right(idxRight)
          idxRight += 1
        }
      }

      merged
    }

    def mergeSort(lo: Int, hi: Int): Array[Int] = {
      if (lo >= hi) return Array(arr(lo))
      val mid = getMid(lo, hi)
      merge(mergeSort(lo, mid), mergeSort(mid + 1, hi))
    }

    mergeSort(0, arr.length - 1)
  }


}
