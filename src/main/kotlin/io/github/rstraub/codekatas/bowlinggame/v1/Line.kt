package io.github.rstraub.codekatas.bowlinggame.v1

class Line(scorecard: String) {
    val score: Int

    init {
        score = scorecard.asSequence()
                .map { it.toString().toInt() }
                .reduce { acc, throwScore -> acc + throwScore }
    }
}
