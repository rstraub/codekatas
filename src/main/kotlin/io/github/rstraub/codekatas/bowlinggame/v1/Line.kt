package io.github.rstraub.codekatas.bowlinggame.v1

class Line(scorecard: String) {
    val score: Int

    init {
        score = scorecard.asSequence()
                .map { it.toString() }
                .map {
                    when(it) {
                        "-" -> 0
                        else -> it.toInt()
                    }
                }
                .reduce { acc, throwScore -> acc + throwScore }
    }
}
