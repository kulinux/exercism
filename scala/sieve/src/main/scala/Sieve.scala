

sealed abstract class Mark
object MaybePrime extends Mark
object Prime extends Mark
object NotPrime extends Mark


object Sieve {

  def mark(primes: Seq[(Int, Mark)], chosen: Int) : Seq[(Int, Mark)] = {
      primes.
        map{
          case (i, mark) if (i % chosen == 0)  => (i, NotPrime)
          case (i, mark) if(i % chosen != 0)  => (i, MaybePrime)
        }
  }

  def passOne(primes: Seq[(Int, Mark)]) : Seq[(Int, Mark)] = {
    val maybePrime = primes
      .find( _._2 == MaybePrime )
      .map( _._1 )

    val nextSeq = mark(primes, maybePrime.get)
    nextSeq

  }

  def primes(limit: Int) : List[Int] = {
    val range : Seq[Int] = 2 to limit toSeq
    val a: List[Int] = range.toList
    a
  }
}
