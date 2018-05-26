import scala.util.matching.Regex

object Task1 {
  def toKelvin(t: String): Double = {
    tempTodounble(t) * (5.0 / 9.0) + 32.0
  }

  def tempTodounble(t: String): Double = {
    t.split("(\\d+,\\d+)")
      .filter(_.nonEmpty)
      .toList.head
      .replaceAll("[a-zA-Z]", "").toDouble
  }

  def parseTemp(t: String): Double = {
    val numberPattern: Regex = "F(?!=\\w\\d)(?!\\w)".r
    numberPattern.findFirstMatchIn(t) match {
      case Some(_) => toKelvin(t)
      case None => tempTodounble(t)
    }
  }

  def quantityOfHeat(c: Double, m: Double, t: String): Double = {
    c * m * parseTemp(t)
  }

//  def main(args: Array[String]): Unit = {
  ////    println(quantityOfHeat(12, 13, "32.2F"))
  ////    println(quantityOfHeat(12, 13, "32.2C"))
  ////    println(quantityOfHeat(12, 13, "32.2K"))
  ////    println(quantityOfHeat(12, 13, "32K"))
  ////
  ////  }
}
