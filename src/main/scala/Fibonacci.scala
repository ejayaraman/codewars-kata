object Fibonacci {

  def sequence(input: List[Int]): List[Int] = {
    input ::: List(input.takeRight(2).sum)
  }

}
