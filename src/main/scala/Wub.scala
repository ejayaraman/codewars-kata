object Wub {

  def songDecoder(song: String): String = song.replaceAll("(WUB)+", " ").trim

}