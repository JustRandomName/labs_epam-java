class Sourse {

  //  val originalList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  def proc(originalList: List[Int]): Unit = {
    val resultList = originalList.filter(_ % 2 == 0)
    println(resultList)

  }

}
