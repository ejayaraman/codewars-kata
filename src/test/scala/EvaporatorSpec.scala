import org.scalatest._

class EvaporatorSpec extends FlatSpec with Matchers {
  "evaporator(10,10,10)" should "return 22" in {
    Evaporator.evaporator(10, 10, 10) should be(22)
  }
}