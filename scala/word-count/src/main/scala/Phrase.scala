

class Phrase(ph : String) {
  def filter(a : Seq[String]) = a.map( x =>
    x.filter(y => y.isLetter || y.isDigit || y == ''')
  ).filter(!_.isEmpty).map(_.toLowerCase)

  def wordCount : Map[String, Int] = {
    val tokens = filter(ph.split(" |,"))


    tokens.map( x =>
      (x -> tokens.filter( _ == x ).size)
    ) toMap
  }
}
