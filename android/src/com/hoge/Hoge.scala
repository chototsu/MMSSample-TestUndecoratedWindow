package com.example.hoge
import com.jme3.math.Vector3f
import com.typesafe.scalalogging.slf4j.Logging
import com.example.app.Fuga

object Hoge {
  def main(args : Array[String]) = {
    val v = new Vector3f()
    val h = new Fuga()
    h.sayFuga()
  }
}
class Hoge extends Logging{
  def sayHoge() = {
    logger.info("hogehoge")
  }
}
