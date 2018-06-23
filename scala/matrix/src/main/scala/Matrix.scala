

class Matrix(elem: List[Int]) {
  val size = Math.sqrt(elem.size).toInt

  def column(col: Int) : Vector[Int] =
    elem.zipWithIndex
    .filter(_._2 % size == col)
    .map(_._1)
    .toVector

  def row(row: Int) : Vector[Int] =
    elem
    .slice( size * row, size * (row + 1) )
    .toVector
}

object Matrix {

  def apply(str: String) : Matrix = {

   val seq = str
    .split( "\n" )
    .flatMap(_.split( " " ))
    .map(_.toInt)
    .foldLeft( List[Int]() )( _ :+ _ )

    new Matrix(seq)
  }
}
