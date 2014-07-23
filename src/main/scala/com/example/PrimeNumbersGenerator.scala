package com.example

/**
 * Created by Uri_Keinan on 7/20/14.
 */
class PrimeNumbersGenerator {
  def For(i: Int): Seq [Int] = {
    var primes = Seq[Int]()
    var i2 = i
    for(candidate <-2 until i2) {
      while (i2 % candidate == 0) {
        primes = primes :+ candidate
        i2 = i2 / candidate
      }
    }

    if(i2>1)
      primes = primes :+(i2)


      primes
  }

}
