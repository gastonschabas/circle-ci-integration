import org.scalatestplus.play._
import org.scalatestplus.play.guice.{
  GuiceOneServerPerSuite,
  GuiceOneServerPerTest
}

/**
  * Runs a browser test using Fluentium against a play application on a server port.
  */
class BrowserSpec
    extends PlaySpec
    with OneBrowserPerSuite
    with GuiceOneServerPerSuite
    with HtmlUnitFactory
    with ServerProvider {

  "Application" should {

    "work from within a browser" in {

      go to ("http://localhost:" + port)

      pageSource must include("Your new application is ready.")
    }

    "Hi! message is returned" in {

      go to ("http://localhost:" + port + "/message")

      pageSource must include("Hi!")
    }

    "first /count" in {

      go to ("http://localhost:" + port + "/count")

      pageSource must include("0")
    }

    "second /count" in {

      go to ("http://localhost:" + port + "/count")

      pageSource must include("1")
    }
  }
}
