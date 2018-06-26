

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
    primes
      .find( _._2 == MaybePrime )
      .map( _._1 )
      .map( x => passOne( mark(primes, x) ) )
      .getOrElse( primes )
  }

  def primes(limit: Int) : List[Int] = {
    val initData = 2 to limit map( (_, MaybePrime) )
    val res = passOne(initData)

    res
      .filter(_._2 == Prime)
      .map(_._1)
      .toList

  }
}
