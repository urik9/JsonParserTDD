package com.example

/**
 * Created by Uri_Keinan on 7/22/14.
 */
case class JsonObject(content: Map[String, JsonValue])extends JsonValue {

}

trait JsonValue

case class JsonNumber(i: Int) extends JsonValue {

}

case class JsonString(x: String) extends JsonValue {

}

case class JsonBoolean(b: Boolean) extends JsonValue{
}

case class JsonArray(a:JsonValue*) extends JsonValue{

}

