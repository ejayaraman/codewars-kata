object EnoughIsEnough {

  def deleteNth(elements: List[Int], maxOccurrences: Int): List[Int] = {

    val zippedWithIndex = elements.zipWithIndex
    val indexesToDelete = elements.flatMap {
      element =>
        zippedWithIndex.filter {
          _._1 == element && elements.count(_ == element) > maxOccurrences
        }.map(_._2).drop(maxOccurrences)
    }.toSet


    zippedWithIndex.filterNot {
      case (element, index) =>
        indexesToDelete.contains(index)
    }.map(_._1)
  }
}
