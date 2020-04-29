object EnoughIsEnough {

  def deleteNth(elements: List[Int], maxOccurrences: Int): List[Int] = {

    val toDeleteIndexes = elements.flatMap {
      value =>
        elements.zipWithIndex.filter(_._1 == value && elements.count(_ == value) > maxOccurrences).map(_._2).drop(maxOccurrences)
    }.toSet


    elements.zipWithIndex.filterNot {
      value =>
        toDeleteIndexes.contains(value._2)
    }.map(_._1)
  }
}
