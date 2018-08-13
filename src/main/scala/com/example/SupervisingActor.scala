package com.example

import akka.actor.{Actor, ActorSystem, Props}

class SupervisingActor extends Actor {
  val supervisedChild = context.actorOf(Props[SupervisedActor], "supervised-actor")

  override def receive: Receive = {
    case "failChild" => supervisedChild ! "fail"
  }
}

class SupervisedActor extends Actor {
  override def preStart(): Unit = println("supervised actor started")
  override def postStop(): Unit = println("supervised actor stopped")

  override def receive: Receive = {
    case "fail" =>
      println("supervised actor fail message received")
      throw new Exception("supervised actor failed")
  }
}

object Main extends App {
  implicit val system = ActorSystem("supervisingSystem")
  val supervisingActor = system.actorOf(Props[SupervisingActor])

  supervisingActor ! "failChild"
}
