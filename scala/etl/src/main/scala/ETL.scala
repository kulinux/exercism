object ETL {
  def transform(old : Map[Int, Seq[String]]) = old flatMap (
    x => (x._2 map (y => (y.toLowerCase, x._1))))
}
