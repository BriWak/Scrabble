package app.views

import app.models._

object GetWord {

    def apply(word: String): Unit = {
      val validWordSet = scala.io.Source.fromFile ("/usr/share/dict/british-english").getLines.toSet

      if (validWordSet.contains (word) ) {
        Prompt.reply (s"\nCongratulations you scored ${CheckLetterScore(word)} Points.")
        Decision.playAgain
      } else {
        Prompt.reply ("\nSorry, that isn't a valid word.")
        Decision.playAgain
      }
    }
}