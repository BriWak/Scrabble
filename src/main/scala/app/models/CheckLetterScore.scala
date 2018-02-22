package app.models

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
