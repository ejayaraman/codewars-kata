import org.scalatest._

class MiddleCharSpec extends FlatSpec with Matchers {

  val tests = List(
    ("test",    "es"),
    ("testing", "t"),
    ("middle",  "dd"),
    ("A",       "A"),
    ("of",      "of")
  )

  tests.foreach {
    case (input, expected) =>
      s"middle($input)" should s"return $expected" in {
        MiddleChar.middle(input) should be (expected)
      }
  }
}