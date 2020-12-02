import scala.annotation.tailrec

object KarateChop {
  def chopWithZip(search: Int, arr: Array[Int]): Int = {
    if(arr.contains(search)) {
      arr.indexOf(search)
//      arr.zipWithIndex.find(_._1 == search).get._2
    } else {
      -1
    }
  }

  // source: https://arthur.gonigberg.com/2011/03/07/scala-and-codekata/
  def chop(needle: Int, haystack: Array[Int]): Int = {
    if (haystack.length == 0) {
      return -1
    }
    var min = 0
    var max = haystack.length - 1

    do {
      val middle = min + (max - min) / 2
      val middleElement = haystack(middle)
      if (middleElement == needle) {
        return middle
      }
      else if (middleElement > needle) {
        max = middle - 1
      }
      else if (middleElement < needle) {
        min = middle + 1
      }

    } while (min <= max)

    -1
  }

  def chop1(needle: Int, haystack: Array[Int]): Int = {
    if (haystack.length == 0) {
      return -1
    }

    @tailrec
    def chop(min: Int, max: Int): Int = {
      val middle = min + (max - min) / 2
      val middleElement = haystack(middle)
      if (middleElement == needle) {
        middle
      }
      else if (middleElement > needle && min < max)  {
        chop(min, middle - 1)
      }
      else if (middleElement < needle && min < max) {
        chop(middle + 1, max)
      } else {
        -1
      }
    }
    chop(0, haystack.length - 1)
  }

  def chop2(needle: Int, haystack: Array[Int]): Int = {
    if (haystack.length == 0) {
      return -1
    }

    @tailrec
    def chop(min: Int, max: Int): Int = {
      val middle = min + (max - min) / 2
      val middleElement = haystack(middle)
      if (middleElement == needle) {
        middle
      }
      else if (middleElement > needle && min < max)  {
        chop(min, middle - 1)
      }
      else if (middleElement < needle && min < max) {
        chop(middle + 1, max)
      } else {
        -1
      }
    }
    chop(0, haystack.length - 1)
  }


}
