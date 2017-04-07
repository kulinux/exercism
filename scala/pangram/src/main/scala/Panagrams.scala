object Pangrams {
  val Alp = 'a' to 'z'

  def f(str : String, alp : Seq[Char]) : Seq[Char] = {
    if (str.isEmpty) return alp
    val restAlp = alp filter(x => x != str.head)
    return f(str.tail, restAlp)
  }

  def isPangram(str : String) = f(str.toLowerCase, Alp).isEmpty

}
