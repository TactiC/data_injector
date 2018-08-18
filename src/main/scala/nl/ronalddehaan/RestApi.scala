package nl.ronalddehaan

import akka.actor.{ActorRef, ActorSystem}
import akka.util.Timeout

import scala.concurrent.ExecutionContext

class RestAp(system: ActorSystem, timeout: Timeout) {
  implicit val requestTimeout = timeout
  implicit def executionContext = system.dispatcher

  def createActor: ActorRef = system.actorOf(TestActor.props, TestActor.name)
}

trait RestRoutes extends TestApi {

}

trait TestApi {
  import TestActor._
  def createActor(): ActorRef

  implicit def executionContext: ExecutionContext
  implicit def requestTimeout: Timeout

  lazy val boxOffice = createActor()
}