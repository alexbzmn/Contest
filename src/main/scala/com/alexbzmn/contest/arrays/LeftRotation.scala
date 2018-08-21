package com.alexbzmn.contest.arrays

object LeftRotation {

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5)

    arr.indices
      .map(i => arr.length - i)
      .map(i => arr.length % arr.length + 4)

    println()
  }
}
