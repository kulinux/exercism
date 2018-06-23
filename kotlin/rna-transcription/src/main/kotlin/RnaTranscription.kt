fun transcribeCharToRna(d: Char) : Char  =
  when(d) {
    'C' -> 'G'
    'G' -> 'C'
    'T' -> 'A'
    'A' -> 'U'
    else -> { '?' }
  }

fun transcribeToRnaNaive(dna: String): String {
  var res = ""
  for ( c in dna ) {
      res = res + transcribeCharToRna(c)
  }
  return res
}

fun transcribeToRnaFunc(dna: String) : String =
  dna.map(transcribeCharToRna).joinToString("")

fun transcribeToRna(dna: String) = transcribeToRnaNaive(dna)
