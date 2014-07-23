package com.example


/**
 * Created by Uri_Keinan on 7/20/14.
 */
class Stack {
  var items: Array[Int]=new Array(10)
  var size: Int =0

  def push(item: Int) = {
    items(size) = item
    size+=1
  }


  def pop():Int ={
    size-=1
    items(size)
  }
}
