package com.example

import org.specs2.matcher.Scope
import org.specs2.mutable.{After, SpecificationWithJUnit}
import org.specs2.specification.Context

/**
 * Created by Uri_Keinan on 7/20/14.
 */

//
//class MyClassTest extends SpecificationWithJUnit {
//  trait Context extends Scope {
//    val myClass = new MyClass
//
//  }
//  trait ExtendedContext extends Context {
//    val goodbyeLength = myClass.goodbye.length
//  }
//
//  trait ContextWithCleanup extends Context with After {
//    override def after: Any = println("After out test running cleanup code")
//  }
//
//
//  "MyClass" should {
//    "say hello" in new ContextWithCleanup {
//      myClass.hello must_== "Hello World"
//    }
//    "say goodbye"in new Context{
//      myClass.goodbye must_== "Goodbye"
//    }
//  }
//
//}
class PrimeNumbersGeneratorTest extends SpecificationWithJUnit {

  trait Context extends Scope {
    val Generator = new PrimeNumbersGenerator
  }

  "PrimeNumbersGenerator" should {
    "Return Empty List For 1" in new Context {
      Generator.For(1) must_== List[Int]()

    }
    "Return List of 1 Item for 2" in new Context {
      Generator.For(2) must_== List[Int](2)
    }

    "Return List of 1 Item for 3" in new Context {
      Generator.For(3) must_== List[Int](3)
    }
    "Return List of 2 Item for 4" in new Context {
      Generator.For(4) must_== List[Int](2, 2)
    }
    "Return List of 1 Item for 5" in new Context {
      Generator.For(5) must_== List[Int](5)
    }
    "Return List of 2 Item for 5" in new Context {
      Generator.For(6) must_== List[Int](2, 3)
    }
    "Return List of 1 Item for 5" in new Context {
      Generator.For(7) must_== List[Int](7)
    }
    "Return List of 3 Item for 8" in new Context {
      Generator.For(8) must_== List[Int](2, 2, 2)
    }
    "Return List of 3 Item for 9" in new Context {
      Generator.For(9) must_== List[Int](3, 3)
    }
    "Return List of 3 Item for 9" in new Context {
      Generator.For(Int.MaxValue) must_== List[Int](Int.MaxValue)
    }
  }
}