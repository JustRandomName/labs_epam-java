object Task2 {
  case class Human(fName: String, sName: String, pName: String, race: String) {
    def unapply(): String =
      "Name: " + fName + ", Race: " + race
  }

  case class Canine(name: String, breed: String) {
    def unapply(): String =
      "Name: " + name + ", Breed: " + breed
  }


  def matching(arg: Any): Unit = {
    arg match {
      case Human(_, _, _, _) => println("Hello, man!")
      case Canine(_, _) => println("Hello, pet!")
    }
  }

  def main(args: Array[String]): Unit = {
    val man = Human("Nikita", "Zhuchkevich", "Sergeevich", "elf")
    val animal = Canine("Bobik", "just a dog")
    println("Task #2: ")
    matching(animal)
    matching(man)
  }
}
