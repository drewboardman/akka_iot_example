package com.example

import akka.actor.{Actor, ActorSystem, Props}

import scala.io.StdIn

class PrintMyActorRefActor extends Actor {
  override def receive: Receive = {
    case "printit" =>
      val secondRef = context.actorOf(Props.empty, "second-actor")
      println(s"Second: $secondRef")
    case _ =>
      println("something went wrong. Did not receive printit")
  }
}

object ActorHierarchyExperiments extends App {
  val system = ActorSystem("testSystem")
  val firstRef = system.actorOf(Props[PrintMyActorRefActor], "first-actor")

  println(s"First: $firstRef")
  firstRef ! "printit"

  println("Press ENTER to exit")
  try StdIn.readLine()
  finally system.terminate()
}
