package filters

import javax.inject._
import play.api.mvc._
import scala.concurrent.ExecutionContext

/**
  * @param ec This class is needed to execute code asynchronously.
  * It is used below by the `map` method.
  */
@Singleton
class ExampleFilter @Inject() (implicit ec: ExecutionContext)
    extends EssentialFilter {
  override def apply(next: EssentialAction) =
    EssentialAction { request =>
      next(request).map { result =>
        result.withHeaders("X-ExampleFilter" -> "foo")
      }
    }
}
