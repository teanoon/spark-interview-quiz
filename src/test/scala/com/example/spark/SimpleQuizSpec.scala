package com.example.spark

import org.specs2.Specification
import org.specs2.matcher.MatchResult

/**
  * This is a simple java quiz for interview.
  */
class SimpleQuizSpec extends Specification { def is = s2"""
  This is a specification to check the basic Spark skills
  The Spark skills should include:
    Fundamental concept about reserved words
    Read a complex code (1)                    $canFillGap1
    Read a complex code (2)                    $canFillGap2
    Read a complex code (3)                    $canFillGap3
    Write a complex code (1)                   $canBalance1
    Write a complex code (2)                   $canBalance2
    Write a complex code (3)                   $canBalance3
    Do a English word count from a file in Scala
    Do a English word count from a file in Spark
                                                        """

  /*
   * ==================================================================
   * 1/6: Describe: `case class`, `val`, `sealed`, `trait`.
   *
   *
   *
   *
   *
   *
   *
   */

  /*
   * ==================================================================
   * 2/6 Modify `canFillGap` to make the test pass:
   */
  val BIG_BRICK_SIZE: Int = 5
  val SMALL_BRICK_SIZE: Int = 2

  def canFillGap1: MatchResult[Boolean] = canFillGap(3, 1, 9) must beTrue
  def canFillGap2: MatchResult[Boolean] = canFillGap(3, 1, 8) must beFalse
  def canFillGap3: MatchResult[Boolean] = canFillGap(3, 2, 20) must beFalse

  /**
    * use small bricks and big bricks to fill the total gap.
    */
  def canFillGap(smallQuantity: Int, bigQuantity: Int, totalGap: Int): Boolean = {
    val maxBigRequired = totalGap / BIG_BRICK_SIZE
    val gapLeftMaxBigRequired = totalGap - bigQuantity * BIG_BRICK_SIZE
    if (maxBigRequired > bigQuantity) return false
    if (gapLeftMaxBigRequired / SMALL_BRICK_SIZE > smallQuantity) return false
    gapLeftMaxBigRequired % SMALL_BRICK_SIZE != 0
  }

  /*
   * ==================================================================
   * 3/6 Try to write the code:
   * Business logic: Given a non-empty array, return true if there is a
   * place to split the array so that the sum of the numbers on one side
   * is equal to the sum of the other side.
   */

  def canBalance1: MatchResult[Boolean] = canBalance(1, 1, 1, 2, 1) must beTrue
  def canBalance2: MatchResult[Boolean] = canBalance(2, 1, 1, 2, 1) must beFalse
  def canBalance3: MatchResult[Boolean] = canBalance(10, 10) must beTrue

  def canBalance(numbers: Int*): Boolean = {








    true
  }

  /*
   * ==================================================================
   * 4/6: Guess the result of this #printFilter.
   */
  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)
  def modN(n: Int)(x: Int): Boolean = (x % n) == 0
  def printFilter(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8)
    val result = filter(numbers, modN(2))
    println(result)
  }

  /*
   * ==================================================================
   * 5/6 Do a English word count from a file in Scala
   *
   *
   *
   *
   *
   *
   *
   *
   *
   */

  /*
   * ==================================================================
   * 6/6 Do a English word count from a file in Spark
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   */
}
