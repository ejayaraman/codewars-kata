import scala.util.matching.Regex

object Cubes {
  def isSumOfCubes(s: String): String = {
    val pattern: Regex = "(\\d{1,3})".r

    def isCubic: String => Boolean = { num: String =>
      num.toCharArray.map(x => x.asDigit).map(Math.pow(_,3)).sum == num.toInt
    }

    pattern
      .findAllMatchIn(s)
      .map(_.toString())
      .filter(isCubic)
      .map(_.toInt)
      .toList match {
      case List()    => "Unlucky"
      case cubicList => s"${cubicList.mkString(" ")} ${cubicList.sum} Lucky"
    }
  }
}
