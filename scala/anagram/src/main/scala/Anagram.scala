class Anagram(word : String) {
  def angOneLetter(ct : String, word : String) : Boolean = {
    if (ct.size != word.size) false
    else if (ct.isEmpty) word.isEmpty
    else angOneLetter(ct.tail, word.replaceFirst(ct.head.toString, ""))
  }
  def matches(cdt : Seq[String]) =
    cdt.
      filter( x => x.toUpperCase != word.toUpperCase).
      filter( x => angOneLetter(x.toLowerCase, word.toLowerCase))
}
