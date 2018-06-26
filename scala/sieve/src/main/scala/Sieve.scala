

sealed abstract class Mark
object MaybePrime extends Mark
object Prime extends Mark
object NotPrime extends Mark


object Sieve {

  def mark(primes: Seq[(Int, Mark)], chosen: Int) : Seq[(Int, Mark)] = {
      primes
      .map{
          case (i, mark) if (mark != MaybePrime)  => (i, mark)
          case (i, mark) if (i == chosen)  => (i, Prime)
          case (i, mark) if (i % chosen == 0)  => (i, NotPrime)
          case (i, mark) if(i % chosen != 0)  => (i, MaybePrime)
        }
  }

  def passOne(primes: Seq[(Int, Mark)]) : Seq[(Int, Mark)] = {
    val maybePrime = primes
      .find( _._2 == MaybePrime )
      .map( _._1 )

    if(maybePrime.isDefined) {
      val nextSeq = mark(primes, maybePrime.get)
      passOne(nextSeq)
    } else {
      primes
    }
  }

  def primes(limit: Int) : List[Int] = {
    val range : Seq[Int] = 2 to limit toSeq
    val a = range.map((_, MaybePrime))
    val res = passOne(a)

    res
      .filter(_._2 == Prime)
      .map(_._1)
      .toList

  }
}
