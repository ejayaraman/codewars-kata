object Same {
  def comp(seq1: Seq[Int], seq2: Seq[Int]): Boolean = {

    if (seq1 != null && seq2 != null) {
      seq1.map(int => int * int).sorted == seq2.sorted
    }
    else {
      false
    }
  }
}