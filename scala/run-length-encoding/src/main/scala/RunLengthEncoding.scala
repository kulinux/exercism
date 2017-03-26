object RunLengthEncoding {



  def encode(str: String): String = {
    var number = 0
    str.foldRight("") {(elem, res) =>

      val headAsNumber = res.takeWhile(_.isDigit)
      val restExceptNumber = res.dropWhile(_.isDigit)

      if (res.isEmpty) "" + elem
      else if (res.size == 1 && elem == res.head) "2" + elem
      else if (res.size == 1 && elem != res.head) elem + res
      else if (!headAsNumber.isEmpty && restExceptNumber.head == elem) "" + (headAsNumber.toInt + 1) + restExceptNumber
      else if (headAsNumber.isEmpty && restExceptNumber.head == elem) "" + 2 + restExceptNumber.head + restExceptNumber.tail
      else elem + res
    }
  }


  def decode(str: String): String = str
}
