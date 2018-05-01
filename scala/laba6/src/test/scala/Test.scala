import org.scalatest.FlatSpec

class Test extends FlatSpec {
  "Part_1" should "return (2,4,6,8,10)" in {
    Sourse.proc(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) should be (2, 4, 6, 8, 10)
  }
}
