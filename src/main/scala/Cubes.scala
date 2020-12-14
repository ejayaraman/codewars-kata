import scala.util.matching.Regex

object Cubes {
  def isSumOfCubes(s: String): String = {
    val pattern: Regex = "(\\d{1,3})".r

    def isCubic: String => Boolean =  {
      num:String => num.toCharArray.map(x => x.asDigit).map(x=>x*x*x).sum == num.toInt
    }

    pattern.findAllMatchIn(s).mkString(" ").split(' ').filter(isCubic) match {
      case Array() => "Unlucky"
      case cubicList => s"${cubicList.map(_.toInt).mkString(" ")} ${cubicList.map(_.toInt).sum} Lucky"
    }
  }
}