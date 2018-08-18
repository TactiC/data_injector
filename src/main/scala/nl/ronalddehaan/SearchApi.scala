package nl.ronalddehaan

import akka.actor.{Actor, Props}
import akka.util.Timeout

object SearchApi {

  def props(implicit timeout: Timeout) = Props(new SearchApi)
  def name = "search"


  case class Message(msg: String)
  

}

class SearchApi extends Actor {

  import SearchApi._

  override def receive: Receive = {
    case Message(msg) => println(s"Hello $msg")
  }

}
