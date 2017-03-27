

object Hamming {
  def compute(c1: String, c2: String) : Option[Int] = {
    if (c1.size != c2.size) None
    else if (c1.isEmpty) Some(0)
    else if (c1.head == c2.head) compute(c1.tail, c2.tail)
    else if (c1.head != c2.head) Some(1 + compute(c1.tail, c2.tail).getOrElse(0))
    else None
  }
}
