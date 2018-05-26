import org.scalatest.{FlatSpec, Matchers}

class Test extends FlatSpec with Matchers {
  "Part_1" should "" in {
    Source.produce(List(1, 2, 3, 4, 5)) should be(120)
  }

  "Part_2" should "" in {
    Source.produce(List(0, 2, 3, 4, 5)) should be(0)
  }

  "Part_3" should "" in {
    Source.part2(List(1, 12, 3, 14, 13, 6)) should be(List(1, 3, 13))
  }

  "Part_4" should "" in {
    Source.part2(List(20, 12, 3, 14, 13, 78)) should be(List(3, 13))
  }

  "Part_5" should "" in {
    Source.mainDiag(Array(Array(1, 2, 1), Array(3, 4, 1), Array(6, 7, 8)), 3) should be(32)
  }

  "Part_6" should "" in {
    Source.mainDiag(Array(Array(1, 1, 1, 12), Array(3, 4, 1, 12), Array(6, 7, 8, 12), Array(0, 0, 0, 0)), 4) should be(0)
  }

  "Part_7" should "" in {
    Source.secondDiag(Array(Array(1, 2, 1), Array(3, 4, 1), Array(6, 7, 8)), 3) should be(24)
  }

  "Part_8" should "" in {
    Source.secondDiag(Array(Array(1, 1, 1, 12), Array(3, 4, 1, 12), Array(6, 7, 8, 12), Array(0, 0, 0, 0)), 4, 4) should be(0)
  }
}
