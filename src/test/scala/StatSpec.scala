import org.scalatest._
import org.scalatest.Assertions._

import StatSpec._

class StatSpec extends FlatSpec {
  it should "pass basic tests" in {
    testing("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17",
      "Range: 01|01|18 Average: 01|38|05 Median: 01|32|34")
    testing("02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41",
      "Range: 00|31|17 Average: 02|26|18 Median: 02|22|00")
  }
}

object StatSpec {

  private def testing(s: String, expect: String): Unit = {
    println("Testing:\n" + s)
    val actual: String = Stat.stat(s)
    println("Actual: " + actual)
    println("Expect: " + expect)
    println("*")
    assertResult(expect){actual}
  }
}