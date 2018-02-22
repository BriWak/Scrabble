package app

import app.views.Prompt

object Scrabble extends App {

  def getWord: Unit = {
    val validWordSet = scala.io.Source.fromFile ("/usr/share/dict/british-english").getLines.toSet
    val word = Prompt.ask ("\nEnter a word: ").toLowerCase

    if (validWordSet.contains (word) ) {
    Prompt.reply (s"\nCongratulations you scored ${CheckLetterScore (word)} Points.")
    Decision.prompt
  } else {
    Prompt.reply ("\nSorry, that isn't a valid word.")
    Decision.prompt
  }
  }
  Scrabble.getWord
}
object CheckLetterScore {

  def apply(input : String) : Int = {
    val oneP = input.intersect("eaionrtlsu").length
    val twoP = input.intersect("dg").length * 2
    val threeP = input.intersect("bcmp").length * 3
    val fourP = input.intersect("fhvwy").length * 4
    val fiveP = input.intersect("k").length * 5
    val eightP = input.intersect("jx").length * 8
    val tenP = input.intersect("qz").length * 10

    List(oneP,twoP,threeP,fourP,fiveP,eightP,tenP).sum
  }
}

object Decision {
  def prompt : Unit = {
    Prompt.ask("\nWould you like to try again? (y/n):").toLowerCase match {
      case "y" => Scrabble.getWord
      case "n" => println("\nGoodbye")
      case _ => {
        println("\nPlease enter either y or n.")
        prompt
      }
    }
  }
}