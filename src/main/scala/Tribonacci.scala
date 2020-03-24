object Tribonacci {
  @scala.annotation.tailrec
  def tribonacci[T: Numeric](signature: List[T], n: Int): List[T] = {
    if (signature.size == n) {
      signature
    } else if (signature.size > n) {
      signature.take(n)
    }
    else {
      tribonacci(signature ::: List(signature.takeRight(3).sum), n)
    }
  }
}