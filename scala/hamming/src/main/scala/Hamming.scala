

object Hamming {
  def compute(c1: String, c2: String) : Some[Int] = 
    if (c1.size != c2.size) None[Int]

    if (c1.isEmpty) Some(0)
    else if (c1.head == c1.head) compute(c1.tail, c2.tail)
    else if (c1.head != c1.head) 1 + compute(c1.tail, c2.tail)
    else None
}