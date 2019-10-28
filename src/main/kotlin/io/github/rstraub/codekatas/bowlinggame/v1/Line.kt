package io.github.rstraub.codekatas.bowlinggame.v1

class Line(scorecard: String) {
    val score: Int = when (scorecard) {
        "X" -> 10
        "-" -> 0
        else -> scorecard.toInt()
    }
}
