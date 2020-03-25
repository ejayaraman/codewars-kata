object Tribonacci {
  @scala.annotation.tailrec
  def tribonacci[T: Numeric](signature: List[T], n: Int): List[T] = {
    n.compareTo(signature.size) match {
      case 0 | -1 => signature.take(n)
      case 1 => tribonacci(signature ::: List(signature.takeRight(3).sum), n)
    }
  }
}