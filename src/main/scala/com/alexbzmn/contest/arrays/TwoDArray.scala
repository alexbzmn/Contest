package com.alexbzmn.contest.arrays

import java.io.PrintWriter

object TwoDArray {

  // Complete the hourglassSum function below.
  def hourglassSum(arr: Array[Array[Int]]): Int = {

    var sum: Int = 0
    var sumList: Seq[Int] = Seq()

    for (i <- 1 until (arr.length - 1)) {
      for (j <- 1 until (arr(0).length - 1)) {
        sumList = sumList :+ Array(
          arr(i - 1)(j - 1),
          arr(i - 1)(j),
          arr(i - 1)(j + 1),
          arr(i)(j),
          arr(i + 1)(j - 1),
          arr(i + 1)(j),
          arr(i + 1)(j + 1)
        ).sum
      }
    }

    sumList.max
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = hourglassSum(arr)

    printWriter.println(result)

    printWriter.close()
  }
}