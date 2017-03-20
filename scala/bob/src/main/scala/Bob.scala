
class Bob {
  def hey(q : String) = {
    if (q == q.toUpperCase && q.takeRight(1) == "!")
      "Whoa, chill out!"
    else if(q.takeRight(1) == "?")
      "Sure."
    else
      "Whatever."
  }
}
