//package com.example
//
//import com.example.AST.{JsonInt, JsonString, JsonField, JsonObject}
//import org.specs2.matcher.Scope
//import org.specs2.mutable.SpecificationWithJUnit
//
///**
// * Created by Uri_Keinan on 7/20/14.
// */
//class JsonPrinterTest  extends SpecificationWithJUnit {
//
//    object person {
//      val json = JsonObject(
//        JsonField("name", JsonString("Max"))
//        //        JsonField( "surname", JsonString( "Hammer" ) ),
//        //        JsonField( "age", JsonInt( 40 ) )
//      )
//
//      val compact = """{"name":"Max"}"""
//
//      val pretty =
//        """
//          |{
//          |  "name": "Max",
//          |  "surname": "Hammer",
//          |  "age": 40
//          |}
//        """.stripMargin.trim
//    }
//
//
//    trait Context extends Scope {
//      val jsonPrinter = new JsonPrinter
//    }
//
//    "Printer" should{
//      "Return empty json when empty object passed" in new Context {
//        jsonPrinter.printJson(JsonObject()) must_== """{}"""
//      }
//      "Return one string field" in new Context{
//      jsonPrinter.printJson(person.json) must_==(person.compact)
//      }
//    }
//
//
//  }
