import org.scalatest._
import org.scalatest.Assertions._

import CubesTest._

class CubesTest extends FlatSpec {
  it should "pass basic tests" in {
    testing("Once upon a midnight dreary, while100 I pondered, 9026315weak and weary -827&()", "Unlucky")
    testing("Once 1000upon a midnight 110dreary, while100 I pondered, 9026315weak and weary -827&()", "0 0 Lucky")

  }
}

object CubesTest {
  private def testing(s: String, expect: String): Unit = {
    println("Testing1: " + s)
    val actual: String = Cubes.isSumOfCubes(s)
    println("Actual: " + actual)
    println("Expect: " + expect)
    println("-")
    assertResult(expect){actual}
  }
}
