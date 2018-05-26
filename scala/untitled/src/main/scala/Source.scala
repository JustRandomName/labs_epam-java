import scala.annotation.tailrec

object Source {
  @tailrec
  def mainDiag(matrix: Array[Array[Int]], row: Int, result: Int = 1, counter: Int = 1): Int = {
    if (counter == row) {
      result
    } else {
      mainDiag(matrix, row, result * matrix(counter)(counter), counter + 1)
    }
  }
  @tailrec
  def secondDiag(matrix: Array[Array[Int]], row: Int, result: Int = 1, counter: Int = 1): Int = {
    if (counter == row) {
      result
    } else {
      secondDiag(matrix, row, result * matrix(row - counter)(counter - 1), counter + 1)
    }
  }

  def part2(original: List[Int]): List[Int] = {
    equalsLists(fib(original.max), original)
  }

  def produce(list: List[Int]): Int = {
    list.foldLeft(1) {
      _ * _
    }
  }

  @tailrec
  def fib(cnt: Int, low: BigInt = 0, high: BigInt = 1, sofar: List[BigInt] = Nil): List[BigInt] = {
    if (cnt == 0)
      (low :: sofar).reverse
    else
      fib(cnt - 1, high, low + high, low :: sofar)
  }

  def equalsLists(fib: List[BigInt], originList: List[Int]): List[Int] = {
    originList.filter(fib.contains(_))
  }
}
