object Stat {

  def stat(results: String): String = {
    val resultsInSeconds = results.split(",").map(convertToSeconds).sorted.toList
    val average = resultsInSeconds.sum / resultsInSeconds.length
    val range = resultsInSeconds.max - resultsInSeconds.min
    s"Range: ${secondsToNotion(range)} Average: ${secondsToNotion(average)} Median: ${secondsToNotion(median(resultsInSeconds))}"
  }

  def convertToSeconds(result: String): Long = {
    val resultPattern = """\s*(\d+)\|\s*(\d+)\|\s*(\d+)""".r
    result match {
      case resultPattern(hours, minutes, seconds) => hours.toLong * 3600 + minutes.toLong * 60 + seconds.toLong
    }

  }

  def secondsToNotion(seconds: Long): String = {
    val hour = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val second = (seconds % 3600) % 60

    f"$hour%02d|$minutes%02d|$second%02d"
  }

  def median(resultsInSeconds: List[Long]): Long = {
    val numberOfResults = resultsInSeconds.length
    val medianIndex = numberOfResults / 2
    if (numberOfResults % 2 != 0) {
      resultsInSeconds(medianIndex)
    } else {
      (resultsInSeconds(medianIndex) + resultsInSeconds(medianIndex - 1)) / 2
    }
  }
}