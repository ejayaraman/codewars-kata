import scala.annotation.tailrec
import scala.collection.immutable.SortedMap

object PrimeDecomp {

  def factors(m: Int): String = {
    @tailrec
    def decomposition(num: Int, factor: Int, decomp: List[Int]): List[Int] = {
      if (num % factor == 0) {
        decomposition(num / factor, factor, factor :: decomp)
      } else if (num % factor > 0 && factor < num) {
        decomposition(num, factor + 1, decomp)
      } else {
        decomp
      }
    }
    val decomposed: List[Int] = decomposition(m, 2, List.empty).sorted
    val output: SortedMap[Int, Int] = SortedMap
      .empty[Int, Int] ++ decomposed.groupBy(identity).mapValues(v => v.size)
    val formattedOutput =
      for ((k, v) <- output)
        yield v match {
          case v if v > 1 => s"($k**$v)"
          case _          => s"($k)"
        }
    formattedOutput.mkString
  }
}
