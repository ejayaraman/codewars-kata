object BouncingBall {

  def bouncingBall(h: Double, bounce: Double, window: Double): Int = {
    val ballGoingDown = 1
    val ballBouncingUp = 1

    def countOfBallPassing(h: Double, ballPassCount: Int): Int = {
      val newHeight = h * bounce
      if (newHeight > window)
        countOfBallPassing(newHeight, ballPassCount + ballGoingDown + ballBouncingUp)
      else
        ballPassCount
    }

    if (h > 0 && bounce > 0 && bounce < 1 && window < h) {
      val initialCount = 1
      countOfBallPassing(h, ballGoingDown)
    }
    else
      -1
  }
}