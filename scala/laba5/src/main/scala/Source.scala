

object Source {
  def main(args: Array[String]): Unit = {
    val row: Int = 5
    val col: Int = 5
    var i: Int = 0
    var j: Int = 0
    val mat = Array[Int](row, col)
    mat(0,1,2,3,4,5,6,7,8,9)
    val mainDiag = Array[Int](row)
    for (x <- 0 to row) {
      mainDiag :+ mat(i)(j)
      i = i + 1
      j = j + 1
    }
    print(mainDiag)

  }
}
