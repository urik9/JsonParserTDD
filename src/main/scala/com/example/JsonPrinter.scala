//package com.example
//
//import com.example.AST.JsonObject
//
///**
// * Created by Uri_Keinan on 7/20/14.
// */
//class JsonPrinter {
//  def printJson(obj: JsonObject) = {
//    if(obj.fields.isEmpty){
//      """{}"""
//    }
//    else{
//      var res = ""
//      for(field <- obj.fields){
//        res = field.name.concat(field.value.toString)
//      }
//      res
//    }
//  }
//
//}
