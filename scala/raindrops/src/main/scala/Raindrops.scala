
object Raindrops {
  def numbers(n: Int) = {
    var s = Set[Int]()
    for(i <- 0 to n; j <- i to n; if (i * j == n)) s = s + i + j
    s
  }
  def convert(n: Int): String = {
    val res = numbers(n) map (
      x => x match {
        case 3 => "Pling"
        case 5 => "Plang"
        case 7 => "Plong"
        case _ => ""
      }
    ) filter (!_.isEmpty)
    if (res.size == 0) return n.toString
    else return res.mkString("")
}

}
