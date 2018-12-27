package cn.chenhuanming.study.scala.akka.helloAkka

import akka.actor.Actor

/**
  *
  * @author chenhuanming
  *         Created at 2018/6/3
  */
class HelloActor extends Actor{

  def receive= {
    case "hello" => println("hell back to u")
    case _ => println("huh?")
  }

}
