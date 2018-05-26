import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object Sourse {

  //  val originalList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  @tailrec
  def proc(originalList: List[Int], counter: Int, resultList: ArrayBuffer[Int], index: Int): ArrayBuffer[Int] = {
    if (counter == originalList.size) {
      resultList
    } else {
      if (0 == originalList(counter) % 2) {
        resultList += originalList.apply(counter)
        proc(originalList, counter + 1, resultList, index + 1)
      }
      else {
        proc(originalList, counter + 1, resultList, index)
      }
    }
  }
}
