object Stat {

  def stat(results: String): String = {
    val resultsInSeconds = results.split(",").map(convertToSeconds).sorted
    val average = (resultsInSeconds.sum) / resultsInSeconds.length
    val range = (resultsInSeconds.max - resultsInSeconds.min)
    val median = if (resultsInSeconds.length % 2 != 0) {
      resultsInSeconds((resultsInSeconds.length / 2))
    } else {
      (resultsInSeconds(resultsInSeconds.length / 2) + resultsInSeconds((resultsInSeconds.length / 2) - 1)) / 2
    }
    s"Range: ${secondsToNotion(range)} Average: ${secondsToNotion(average)} Median: ${secondsToNotion(median)}"

  }

  def convertToSeconds(result: String): Long = {
    val temp = result.split('|').map(_.trim.toLong)
    temp(0) * 3600 + temp(1) * 60 + temp(2)
  }

  def secondsToNotion(seconds: Long): String = {
    val hour = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val second = (seconds % 3600) % 60

    f"$hour%02d|$minutes%02d|$second%02d"
  }
}