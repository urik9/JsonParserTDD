import com.example.{JsonString, JsonNumber, JsonArray, JsonObject}

//package com.example
//
//import java.io.{StringReader, BufferedReader, StreamTokenizer}
//
//import org.specs2.matcher.Scope
//import org.specs2.mutable.SpecificationWithJUnit
//
///**
// * Created by Uri_Keinan on 7/24/14.
// */
//class LearningTests extends SpecificationWithJUnit{
//
//  val json: String = "{a:3}"
//
//
//  val stDemo: StreamTokenizer = new StreamTokenizer(new BufferedReader(new StringReader(json)))
//  while(stDemo.nextToken()!= StreamTokenizer.TT_EOF) {
//  }
//
//  trait Context extends Scope {
//    val Streamer = new LearningTests
//
//    Streamer should {
//      "mark input as jsonObject" in new Context {
//        Streamer.stDemo. must_== JsonObject
//      }
//
//    }
//  }
//
//}
