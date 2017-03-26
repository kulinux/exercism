object RunLengthEncoding {

  def encode(str: String): String = {
    str.foldRight("") {(elem, res) =>

      val in = res.takeWhile(_.isDigit)
      val rest = res.dropWhile(_.isDigit)

      if (res.isEmpty) "" + elem
      else if (res.size == 1 && elem == res.head) "2" + elem
      else if (res.size == 1 && elem != res.head) elem + res
      else if (!in.isEmpty && rest.head == elem) (in.toInt + 1).toString + rest
      else if (in.isEmpty && rest.head == elem) "2" + rest.head + rest.tail
      else elem + res
    }
  }


  def decode(str: String): String = str.foldRight(""){
    (elem, res) =>
      if (res.isEmpty) elem.toString
      if (res.size == 1 && elem.isDigit) res * elem.asDigit
      else if (res.size == 1 && !elem.isDigit) elem + res
      else if (elem.isDigit && res.head == res.tail.head) res.head.toString * (10 * elem.asDigit) + res
      else if (elem.isDigit) res.head.toString * elem.asDigit + res.tail
      else elem + res
  }
     
}
