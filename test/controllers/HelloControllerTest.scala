package controllers

import org.scalatest.FunSuite
import play.api.mvc.{Action, AnyContent, Results}
import play.api.test.{DefaultAwaitTimeout, FakeRequest, Helpers, StubControllerComponentsFactory}

class HelloControllerTest extends FunSuite with StubControllerComponentsFactory with DefaultAwaitTimeout with Results {

  val helloController = new HelloController(stubControllerComponents())

  test("return hello! when method is invoked") {
    Helpers.contentAsString(helloController.greet.apply(FakeRequest()))
  }

}
