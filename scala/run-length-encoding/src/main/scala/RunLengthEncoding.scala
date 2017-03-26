object RunLengthEncoding {



  def encode(str: String): String = {
    var number = 0
    str.foldRight("") {(elem, res) =>
      println(s"$elem  - $res")
      val headAsNumber = res.takeWhile(_.isDigit).toInt
      val restExceptNumber = res.dropWhile(_.isDigit)

      if (res.isEmpty) "" + elem
      else if (res.size == 1 && elem == res.head) "2" + elem
      else if (res.size == 1 && elem != res.head) elem + res
      else if (headAsNumber.isEmpty && res.tail.head == elem) "" + (res.takeWhile(_.isDigit).toInt + 1) + res.dropWhile(_.isDigit)
      else if (!headAsNumber.isEmpty && res.head == elem) "" + 2 + res.head + res.tail
      else elem + res
    }
  }


  def decode(str: String): String = str
}
