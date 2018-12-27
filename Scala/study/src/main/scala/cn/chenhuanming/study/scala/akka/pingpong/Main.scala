package cn.chenhuanming.study.scala.akka.pingpong

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  *
  * @author chenhuanming
  *         Created at 2018/6/3
  */
object Main {
  case object StartMessage
  case object StopMessage
  case object PingMessage
  case object PongMessage

  class Ping(pong:ActorRef) extends Actor{

    var count = 0

    def counting = {
      count += 1
      println(s"ping...${Thread.currentThread().getId}")
    }

    override def receive: Receive = {
      case StartMessage =>
        counting
        pong ! PingMessage
      case PongMessage =>
        if(count>9){
          sender ! StopMessage
          println("beyond 9,ping stop!")
          context.stop(self)
        }else{
          counting
          sender ! PingMessage
        }
    }
  }

  class Pong extends Actor{
    var count = 0

    def counting = {
      count += 1
      println(s"pong...${Thread.currentThread().getId}")
    }
    override def receive: Receive = {
      case StopMessage =>
        println("pong stop")
        context.stop(self)
      case PingMessage =>
        counting
        sender ! PongMessage
    }
  }

  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem("pingPong")

    val pong = actorSystem.actorOf(Props[Pong],"pong")

    val ping = actorSystem.actorOf(Props(new Ping(pong)),"ping")

    ping ! StartMessage
  }
}
