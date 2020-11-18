import org.scalatest._
import org.scalatest.Assertions._

import BouncingBallTest._

class BouncingBallTest extends FlatSpec {
  it should "pass basic tests" in {
    testing(30, 0.66, 1.5, 15)
    testing(3, 0.66, 1.5, 3)
    testing(10, 0.6, 10, -1)
    testing(-5, 0.66, 1.5, -1)
    testing(5, -1, 1.5, -1)

  }
}

object BouncingBallTest {

  private def testing(h: Double, bounce: Double, window: Double, expect: Int): Unit = {
    println("H: " + h + " BOUNCE: " + bounce + " WINDOW: " + window)
    val actual: Int = BouncingBall.bouncingBall(h, bounce, window)
    println("Actual: " + actual)
    println("Expect: " + expect)
    println("-")
    assertResult(expect){actual}
  }
}

