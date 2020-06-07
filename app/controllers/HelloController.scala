package controllers

import javax.inject._
import play.api.mvc._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class HelloController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def greet = Action.async { request =>
    Future {
      Ok("hello!")
    }
  }

}
