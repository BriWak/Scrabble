package app

import app.views.Prompt

object Scrabble extends App {

  val validWordSet = scala.io.Source.fromFile("/usr/share/dict/british-english").getLines.toSet
  val word = Prompt.ask("Enter a word: ").toLowerCase

  if (validWordSet.contains(word)) {
    Prompt.reply(s"Congratulations you scored ${CheckLetterScore(word)} Points")
  } else {
    Prompt.reply("Sorry, that isn't a valid word!")
  }
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