package com.example


/**
 * Created by Uri_Keinan on 7/22/14.
 */
class JsonParser {

  def parseJsonObject(str: String) = {
    var aggregatedMap: Map[String, JsonValue] = Map.empty[String, JsonNumber]


    if (str.trim == "{}")
      JsonObject(Map.empty)
    else {
      val pairs: Array[String] = dropEdges(str).split(",")
      for(possiblePair <- pairs){
        if(balance(possiblePair)==false) {
          throw new Exception("Parentheses don't match")
        }
        else {
          for (pair <- pairs) {
            val temp = pair.split(":", 2)
            val key = temp(0)
            val value = temp(1)
            val result = parseJsonValue(value)
            aggregatedMap+=key -> result
          }
        }
      }
      JsonObject(aggregatedMap)
    }


  }

  def parseJsonValue(value: String): JsonValue = {
    val result = value match {
      case arr if arr.startsWith("[") => parseJsonArray(arr)
      case str if str.startsWith("\"") => JsonString(dropEdges(str))
      case obj if obj.startsWith("{") => parseJsonObject(obj)
      case "true" => JsonBoolean(value.toBoolean)
      case "false" => JsonBoolean(value.toBoolean)
      case (_) => JsonNumber(value.toInt)
    }
    result
  }

  def parseJsonArray(arr: String) = {
    if (dropEdges(arr) isEmpty)
      JsonArray()
    else {
      JsonArray(parseJsonValue(dropEdges(arr)))
    }
  }

  def dropEdges(str: String): String = {
    str.drop(1).dropRight(1)
  }
  def balance(chars: String): Boolean = {
    def balanced(chars: String, stack: String): Boolean = {
      if (chars.isEmpty)
        stack.isEmpty
      else if (chars.head == '[')
        balanced(chars.tail, chars.head + stack)
      else if (chars.head == ']')
        !stack.isEmpty && balanced(chars.tail, stack.tail)
      else
        balanced(chars.tail, stack)
    }

    balanced(chars, "")
  }


}
