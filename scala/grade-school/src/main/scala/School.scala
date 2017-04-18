class School {
  var db = Map[Int, List[String]]()

  def add(std : String, grd : Int) {
    val l = db.toList :+ (grd, List(std))
    db = l.groupBy(_._1).map(
      x => (x._1, x._2 flatMap(y => y._2))
    )
  }

  def grade(grd : Int) : List[String] = db getOrElse (grd, List[String]())

  def sorted : Map[Int, List[String]] = db.toList.sortBy(_._1) toMap
}
