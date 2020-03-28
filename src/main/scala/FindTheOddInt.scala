object FindTheOddInt {
  def findOdd(xs: Seq[Int]): Int = {
    xs.find(int => (xs.count(_ == int) % 2) != 0).get
  }
}