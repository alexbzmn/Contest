package com.alexbzmn.contest.arrays

object LeftRotation {

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5)
    val shift = 4
    val indices = arr.indices
      .map(i => (arr.length - 1) - i)
      .map(i => {
        if (i + shift > arr.length - 1) (i + shift) % arr.length
        else i + shift
      })
      .map(i => (arr.length - 1) - i)

    val newArr: Array[Int] = new Array[Int](arr.length)
    (arr, indices).zipped.foreach((x, idx) => newArr(idx) = x)

    println(newArr.map(_.toString) reduce ((x, y) => x + " " + y))
  }
}
