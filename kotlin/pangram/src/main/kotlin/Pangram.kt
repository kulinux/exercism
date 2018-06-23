object Pangram {
  fun isPangram(word: String) : Boolean {
    return true;
  }

  fun substract(word : String, ch: Char) : String
  {
    return word
      .filter{ it != ch }
  }
}
