//package demo;
//
//class Coder(words: List[String]){
//   private val mnemonics = Map(
//	'2' -> "abc", '3' -> "DEF", '4' -> "GHI" , '5' -> "JKL" , '6' -> "MNO" ,'7' -> "PQRS" , '8' -> "TUV" ,'9' -> "WXYZ"
//   )
//   /* Invert the mnemonic map to give a map from char 'A', ... 'Z' to '2' ... '9' */
//   private val charCode : Map[Char, Char] = for ((digit, str) <- mnemonic; letter <- str) yield (letter -> digit)
//
//   /* Maps a word to the digit string it can represent, for examples "Java" will be produce to "5282" */
//   private def wordCode(word: String) = word.toUpperCase map charCode
//
//   /* A map from digit strings to the words that represent them,
//      e,g. "5882" -> Set("Java", "Kata", "Lava", ...) */
//   private val wordsForNum: Map[String, List[String]] = (words groupBy wordCode) withDefaultValue 0
//
//   /* return all ways to encode a number as a list of words */
//   def encode(number: String) : Set[List[String]] = {
//	if (number.isEmpty) {
//		Set(List())
//	}else{
//		for {
//		    splitPoint <- 1 to number.length
//			word <- wordsForNum(number take splitPoint)
//			rest <- encode(number drop splitPoint)
//		} yield word :: rest
//	}.toSet
//   }
//
//   /* Maps a number to a list of all word phrases that can represent it */
//   def translate(number: String): Set[String] = encode(number) map ( _ mkString " ")
//
//}
