import org.scalatest.{FlatSpec, Matchers}


class karateChopSpec extends FlatSpec with Matchers {
  "karate chopWithZip" should "return" in {
    KarateChop.chopWithZip(3, Array()) shouldBe -1
    KarateChop.chopWithZip(3, Array(1)) shouldBe -1
    KarateChop.chopWithZip(3, Array(3)) shouldBe 0
    KarateChop.chopWithZip(1, Array(1, 3, 5, 7)) shouldBe 0
    KarateChop.chopWithZip(3, Array(1, 3, 5, 7)) shouldBe 1
    KarateChop.chopWithZip(5, Array(1, 3, 5, 7)) shouldBe 2
    KarateChop.chopWithZip(7, Array(1, 3, 5, 7)) shouldBe 3
  }

  "karate chop" should "return" in {
    KarateChop.chop(3, Array()) shouldBe -1
    KarateChop.chop(3, Array(1)) shouldBe -1
    KarateChop.chop(3, Array(3)) shouldBe 0
    KarateChop.chop(1, Array(1, 3, 5, 7)) shouldBe 0
    KarateChop.chop(3, Array(1, 3, 5, 7)) shouldBe 1
    KarateChop.chop(5, Array(1, 2, 3, 4, 5, 7)) shouldBe 4
    KarateChop.chop(7, Array(1, 3, 5, 7)) shouldBe 3
  }

  "karate chop1" should "return" in {
    KarateChop.chop1(3, Array()) shouldBe -1
    KarateChop.chop1(3, Array(1)) shouldBe -1
    KarateChop.chop1(3, Array(3)) shouldBe 0
    KarateChop.chop1(1, Array(1, 3, 5, 7)) shouldBe 0
    KarateChop.chop1(3, Array(1, 3, 5, 7)) shouldBe 1
    KarateChop.chop1(5, Array(1, 2, 3, 4, 5, 7)) shouldBe 4
    KarateChop.chop1(7, Array(1, 3, 5, 7)) shouldBe 3
  }

  "karate chop2" should "return" in {
    KarateChop.chop2(3, Array()) shouldBe -1
    KarateChop.chop2(3, Array(1)) shouldBe -1
    KarateChop.chop2(3, Array(3)) shouldBe 0
    KarateChop.chop2(1, Array(1, 3, 5, 7)) shouldBe 0
    KarateChop.chop2(3, Array(1, 3, 5, 7)) shouldBe 1
    KarateChop.chop2(5, Array(1, 2, 3, 4, 5, 7)) shouldBe 4
    KarateChop.chop2(7, Array(1, 3, 5, 7)) shouldBe 3
  }


}
