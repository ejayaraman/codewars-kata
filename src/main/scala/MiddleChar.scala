object MiddleChar {
  def middle(s: String): String = {
    val stringLength = s.length
    if (stringLength == 1) {
      s
    } else {
      val midPosition = stringLength / 2
      stringLength % 2 match {
        case 0 => s.substring(midPosition - 1, midPosition + 1)
        case _ => s.charAt(midPosition).toString
      }
    }
  }
}