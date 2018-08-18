package nl.ronalddehaan

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import akka.util.Timeout
import com.typesafe.config.Config

import scala.io.StdIn

object Main extends App with RequestTimeout {

  implicit val system = ActorSystem("injector-system")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher


  def searchApi = new SearchApi

  val route =
    path("search") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "hallo"))
      }
    }

  val bindingFuture = Http().bindAndHandle(route, "localhost", 8265)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done
}

trait RequestTimeout {
  import scala.concurrent.duration._
  def requestTimeout(config: Config): Timeout = {
    val t = config.getString("akka.http.server.request-timeout")
    val d = Duration(t)
    FiniteDuration(d.length, d.unit)
  }
}
