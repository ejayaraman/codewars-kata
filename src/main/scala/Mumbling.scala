object Mumbling {
  def accum(s: String): String = {
    s.toLowerCase().zipWithIndex.map { case (x, i) => (x.toString * (i+1)).capitalize }
  }.mkString("-")
}