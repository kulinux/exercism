import scala.language.postfixOps

object Squares {
  def sumOfSquares(n : Int) = (1 to n).map(Math.pow(_, 2)).sum toInt
  def squareOfSums(n : Int) = Math.pow(1 to n sum, 2) toInt
  def difference(n : Int) = sumOfSquares(n) - squareOfSums(n) toInt
}
