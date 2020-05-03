object AlphabetPosition {
//  Use isLetter instead
  def alphabetPosition(text: String): String = {
    text.toLowerCase
      .filter(character => character.toInt > 96 && character.toInt < 123)
      .map(_.toInt - 96)
  }.mkString(" ")
}
