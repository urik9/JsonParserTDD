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
    "generate a string and and a num" in new Context {
      Parser.parseJsonObject("{a:3,b:\"four\"}") must_== JsonObject(Map("a" -> JsonNumber(3), "b" -> JsonString("four")))
    }
    "generate a num and and a boolean true" in new Context {
      Parser.parseJsonObject("{a:3,b:true}") must_== JsonObject(Map("a" -> JsonNumber(3), "b" -> JsonBoolean(true)))
    }
    "generate a num and and a Boolean true" in new Context {
      Parser.parseJsonObject("{a:3,b:false}") must_== JsonObject(Map("a" -> JsonNumber(3), "b" -> JsonBoolean(false)))
    }
    "generate an empty array" in new Context {
      Parser.parseJsonObject("{a:[]}") must_== JsonObject(Map("a" -> JsonArray()))
    }
    "generate an array with one string item" in new Context {
      Parser.parseJsonObject("{a:[\"b\"]}") must_== JsonObject(Map("a" -> JsonArray(JsonString("b"))))
    }
    "generate an array with one int item" in new Context {
      Parser.parseJsonObject("{a:[3]}") must_== JsonObject(Map("a" -> JsonArray(JsonNumber(3))))
    }
    "generate an array with one Boolean item" in new Context {
      Parser.parseJsonObject("{a:[false]}") must_== JsonObject(Map("a" -> JsonArray(JsonBoolean(false))))
    }
    "generate an empty json object inside the json object" in new Context {
      Parser.parseJsonObject("{a:{}}") must_== JsonObject(Map("a" -> JsonObject(Map.empty)))
    }
    "generate an empty json object inside the json object" in new Context {
      Parser.parseJsonObject("{a:{b:5}}") must_== JsonObject(Map("a" -> JsonObject(Map("b" -> JsonNumber(5)))))
    }
//    "generate an empty json object inside the json object" in new Context {
//      Parser.parseJsonObject("{a:{b:5,c:\"seven\"}}") must_== JsonObject(Map("a" -> JsonObject(Map("b" -> JsonNumber(5), "c" -> JsonString("seven")))))
//    }

        "generate an array with one int one and string items" in new Context {
          Parser.parseJsonObject("{a:[6, \"f\"]}") must_== JsonObject(Map("a" -> JsonArray(JsonNumber(6),JsonString("f"))))
    }
  }


}
