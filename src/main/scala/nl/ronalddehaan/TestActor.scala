package nl.ronalddehaan

import akka.actor.{Actor, Props}
import akka.util.Timeout

object TestActor {
  def props(implicit timeout: Timeout) = Props(new TestActor)
  def name = "TestActor"
}

class TestActor(implicit timeout: Timeout) extends Actor {

  override def receive: Receive = ???
}
