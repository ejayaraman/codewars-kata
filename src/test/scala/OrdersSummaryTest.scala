import org.scalatest._
import org.scalatest.Assertions._

import OrdersSummaryTest._

class OrdersSummaryTest extends FlatSpec {
  it should "pass basic tests" in {
    var l = "GOOG 300 542.0 B, AAPL 50 145.0 B, CSCO 250.0 29 B, GOOG 200 580.0 S";
    var sol = "Buy: 169850 Sell: 116000; Badly formed 1: CSCO 250.0 29 B ;"
    testing(l, sol)

    l = "GOOG 90 160.45 B, JPMC 67 12.8 S, MYSPACE 24.0 210 B, CITI 50 450 B, CSCO 100 55.5 S"
    sol = "Buy: 14440 Sell: 6408; Badly formed 2: MYSPACE 24.0 210 B ;CITI 50 450 B ;"
    testing(l, sol)

    l = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B";
    sol = "Buy: 29499 Sell: 0";
    testing(l, sol)

  }
}

object OrdersSummaryTest {
  private def testing(lst: String, expect: String): Unit = {
    println("Testing: " + lst)
    val actual: String = OrdersSummary.balanceStatements(lst)
    println("Actual: " + actual)
    println("Expect: " + expect)
    println("-")
    assertResult(expect){actual}
  }
}