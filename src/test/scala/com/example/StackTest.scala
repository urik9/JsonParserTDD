package com.example

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.matcher.Scope




/**
 * Created by Uri_Keinan on 7/20/14.
 */
class StackTest extends SpecificationWithJUnit {
  trait Context extends Scope {
    val Stacker = new Stack
    }

  "Stack" should {
    "Return Empty Stack When No Items Added" in new Context {
      Stacker.size must_== 0
    }
    "Return one item when one item added" in new Context {
      Stacker.push(1)
      Stacker.size must_== 1
    }
    "Return stack value for one item" in new Context {
      Stacker.push(3)
      Stacker.pop must_== 3
    }
    "Return last item popped when two items added" in new Context{
      Stacker.push(3)
      Stacker.push(4)
      Stacker.pop must_== 4

    }
    "Return two items when two pushed and two popped" in new Context {
      Stacker.push(3)
      Stacker.push(4)
      Stacker.pop
      Stacker.pop must_==3
    }
  }


}
