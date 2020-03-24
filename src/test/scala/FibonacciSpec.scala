import org.scalatest.FlatSpec

class FibonacciSpec extends FlatSpec {


  "[1,1]" should "return fibonacci" in {
    assert(List(1, 1, 2, 3) == Fibonacci.sequence(List(1, 1, 2)))

  }

}
