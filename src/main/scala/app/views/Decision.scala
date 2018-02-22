package app.views

object Decision {

  def playAgain : Unit = {

    Prompt.ask("\nWould you like to try again? (y/n):").toLowerCase match {
      case "y" => GetWord(Prompt.ask ("\nEnter a word: ").toLowerCase)
      case "n" => println("\nThanks for playing. Goodbye")
      case _ => {
        println("\nPlease enter either y or n.")
        playAgain
      }
    }
  }
}
