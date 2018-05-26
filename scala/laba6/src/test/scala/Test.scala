import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ArrayBuffer

class Test extends FlatSpec with Matchers {
  "Part_1" should "return List(2,4,6,8,10)" in {
    Sourse.proc(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 0, ArrayBuffer(), 0) should be (Array(2, 4, 6, 8, 10))
  }

  "Part_2" should "return (0,2,4,6,8)" in {
    Sourse.proc(List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 0, ArrayBuffer(), 0) should be (Array(0, 2, 4, 6, 8))
  }

  "Part_3" should "return (1,2,3,4)" in {
    Sourse2.proc(List(1, 1, 2, 2, 3 ,3, 4, 4)) should be (List(1,2,3,4))
  }
}
