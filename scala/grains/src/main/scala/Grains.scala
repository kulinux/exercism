import BigInt._
object Grains {
  def square(n : Long) : Option[BigInt] = {
    val k = n match {
      case 1 => Some(BigInt(1))
      case n if (n > 0 && n < 65) => square(n - 1).map(2 * _)
      case _ => None
    }
    return k
  }

  def total : BigInt = {
    val all = 1 to 64 map(x => square(x))
    return all.map(x => x.get).foldLeft(BigInt(0)) ((y, z) => y + z)
  }
}
