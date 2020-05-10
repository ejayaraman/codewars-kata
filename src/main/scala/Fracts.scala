object Fracts {

  def convertFrac(lst: Array[(Long, Long)]): String = {
    val reducedFraction = lst.toList.map(fraction => reduceFraction(2, fraction._1, fraction._2))
    val denominatorList = reducedFraction.map(_._2)
    val leastDenominator = lcd(denominatorList.min, denominatorList)
    reducedFraction.map {
      fraction =>
        val multiplyBy = leastDenominator / fraction._2
        (fraction._1 * multiplyBy, fraction._2 * multiplyBy)
    }.mkString
  }

  @scala.annotation.tailrec
  def lcd(leastDenominator: Long, denominatorList: List[Long]): Long = {
    denominatorList.find(leastDenominator % _ != 0) match {
      case None => leastDenominator
      case _ => lcd(leastDenominator + denominatorList.min, denominatorList)
    }
  }

  @scala.annotation.tailrec
  def reduceFraction(divideByNumber: Int, numerator: Long, denominator: Long): (Long, Long) = {

    if (divideByNumber > numerator) {
      (numerator, denominator)
    } else if ((numerator % divideByNumber == 0) && (denominator % divideByNumber == 0)) {
      reduceFraction(divideByNumber, numerator / divideByNumber, denominator / divideByNumber)
    }
    else {
      reduceFraction(divideByNumber + 1, numerator, denominator)
    }
  }
}