object DNA {
  val ValidNuc = "CAGT"

  def validNuc(char : Char) = ValidNuc.count(_ == char) != 0
}
class DNA(dna: String) {

  import DNA._

  def count(char: Char): Either[String, Int] = {
    if (dna.count(!validNuc(_)) > 0)
      return Left(s"invalid nucleotide '$char'")
    if (!dna.isEmpty && validNuc(char))
      return Left(s"invalid nucleotide '$char'")
    return Right(dna.count(_ == char))
  }

  def nucleotideCounts: Either[String, Map[Char, Int]] = ???
}
