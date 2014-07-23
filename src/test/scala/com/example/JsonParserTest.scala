package com.example

import org.specs2.matcher.Scope
import org.specs2.mutable.SpecificationWithJUnit


/**
 * Created by Uri_Keinan on 7/22/14.
 */
class JsonParserTest extends SpecificationWithJUnit {

  trait Context extends Scope {
    val Parser = new JsonParser
  }

  "Parser" should {
    "genrate empty tree when recieving empty Json" in new Context {
      Parser.parseJsonObject("{}") must_== JsonObject(Map.empty)
    }
    "generate field and num" in new Context {
      Parser.parseJsonObject("{a:3}") must_== JsonObject(Map("a" -> JsonNumber(3)))
    }

    "generate two fields and nums" in new Context {
      Parser.parseJsonObject("{a:3,b:4}") must_== JsonObject(Map("a" -> JsonNumber(3), "b" -> JsonNumber(4)))
    }
    "gerate a string and and a num" in new Context{
      Parser.parseJsonObject("{a:3,b:\"four\"}") must_== JsonObject(Map("a" -> JsonNumber(3),"b" -> JsonString("four")))
    }
    "gerate a num and and a boolean true" in new Context{
      Parser.parseJsonObject("{a:3,b:true}") must_== JsonObject(Map("a" -> JsonNumber(3),"b" -> JsonBoolean(true)))
    }
    "gerate a num and and a boolean true" in new Context{
      Parser.parseJsonObject("{a:3,b:false}") must_== JsonObject(Map("a" -> JsonNumber(3),"b" -> JsonBoolean(false)))
    }
    "generate an empty array" in new Context{
      Parser.parseJsonObject("{a:[]}") must_==JsonObject(Map("a" -> JsonArray()))
    }
    "generate an array with one item" in new Context{
      Parser.parseJsonObject("{a:[\"b\"]}") must_==JsonObject(Map("a" -> JsonArray((JsonString("b")))))
    }
//    "generate a json object inside the json object" in new Context {
//      Parser.parse("{a:{b:1}}") must_== JsonObject(Map("a" -> JsonObject(Map("b" -> JsonNumber(1)))))
//    }
  }


}
