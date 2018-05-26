object Sourse2 {
  def proc(originalList: List[Int]): List[Int] = {
    val list = originalList.toSet
    list.toList
  }
}
