package controllers

import org.scalatest.{FunSuite, Matchers}
import play.api.mvc.Results
import play.api.test.{
  DefaultAwaitTimeout,
  FakeRequest,
  Helpers,
  StubControllerComponentsFactory
}
import play.api.test.Helpers.contentAsString

class HelloControllerTest
    extends FunSuite
    with StubControllerComponentsFactory
    with DefaultAwaitTimeout
    with Results
    with Matchers {

  val helloController = new HelloController(stubControllerComponents())

  test("return hello! when method is invoked") {
    contentAsString(helloController.greet.apply(FakeRequest())) should be(
      "hello!"
    )
  }

  test("return hola! when method is invoked") {
    contentAsString(helloController.hola.apply(FakeRequest())) should be(
      "hola!"
    )
  }

}
