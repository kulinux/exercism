

class Phrase(ph : String) {
  def wordCount2 : Map[String, Int] = {
    val tokens = ph.split(' ')
    tokens.map( x =>
      (x -> tokens.filter( _ == x ).size)
    ) toMap
  }

  def wordCount3(ph : Seq[String], current : Map[String, Int]) : Map[String, Int] = {
    ph match {
      case Nil => Map()
      case head :: tail if (current.contains(head)) =>  current - head + (head -> (current(head) + 1))
      case head :: tail if (!current.contains(head)) => current + (head -> 1)
      case _ => ???
    }
  }

  def wordCount = wordCount3(ph.split(" "), Map())
}
