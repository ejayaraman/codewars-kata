  object Fracts {

    def convertFrac(lst: Array[(Long, Long)]): String = {
      val simplifiedFraction = lst.toList.map(simplify(2,_))
      val denominatorList = simplifiedFraction.map(_._2)
      val leastDenominator = lcd(denominatorList.min, denominatorList)
      simplifiedFraction.map {
        fraction =>
          val multiply = leastDenominator / fraction._2
          (fraction._1 * multiply, fraction._2 * multiply)

      }.mkString
    }

    @scala.annotation.tailrec
    def lcd(seedValue: Long, denominatorList: List[Long]): Long = {
      denominatorList.find(seedValue % _ != 0) match {
        case None => seedValue
        case _ => lcd(seedValue + denominatorList.min, denominatorList)
      }
    }

    @scala.annotation.tailrec
    def simplify(seedValue: Int, fraction: (Long, Long)): (Long, Long) = {
       if (seedValue > fraction._1 ) {
         fraction
       } else if ((fraction._1 % seedValue == 0) && (fraction._2 % seedValue == 0)) {
         simplify(seedValue, (fraction._1 / seedValue, fraction._2 / seedValue))
       }
       else {
         simplify(seedValue + 1, fraction)
      }
    }
  }