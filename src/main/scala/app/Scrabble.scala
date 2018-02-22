package app

import app.views._

object Scrabble extends App {

  GetWord(Prompt.ask ("\nEnter a word: ").toLowerCase)
}