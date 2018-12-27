package cn.chenhuanming.study.scala.akka.helloAkka

import akka.actor.{ActorSystem, Props}

/**
  *
  * @author chenhuanming
  *         Created at 2018/6/3
  */
object Main {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("Hello")

    val helloActor = system.actorOf(Props[HelloActor],"helloActor")

    helloActor ! "hello"

    helloActor ! "some"
  }
}
