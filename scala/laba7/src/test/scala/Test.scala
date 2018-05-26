import org.scalatest.{FlatSpec, Matchers}

class Test extends FlatSpec with Matchers {
  "Part_1" should "return ()" in {
    Task1.quantityOfHeat(12, 13, "32.2F") should be (7782.666666666667)
  }

  "Part_2" should "return ()" in {
    Task1.quantityOfHeat(12, 13, "32.2K") should be (5023.200000000001)
  }

  "Part_3" should "return (2,4,6,8,10)" in {
    Task1.quantityOfHeat(12, 13, "32.2C") should be (5023.200000000001)
  }

  "Part_4" should "return ()" in {
    Task1.quantityOfHeat(12, 13, "32C") should be (4992.0)
  }


}
