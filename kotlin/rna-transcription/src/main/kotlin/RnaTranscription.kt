fun transcribeCharToRna(d: Char) : Char  =
  when(d) {
    'C' -> 'G'
    'G' -> 'C'
    'T' -> 'A'
    'A' -> 'U'
    else -> { '?' }
  }

fun transcribeToRna(dna: String): String {
  var res = ""
  for ( c in dna ) {
      res = res + transcribeCharToRna(c)
  }
  return res
}
