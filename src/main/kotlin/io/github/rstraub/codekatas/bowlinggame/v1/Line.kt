package io.github.rstraub.codekatas.bowlinggame.v1

class Line(scorecard: String) {
    val score: Int

    init {
        score = scorecard.asSequence()
                .map(Char::toString)
                .map(this::throwToScore)
                .reduce { acc, throwScore -> acc + throwScore }
    }

    private fun throwToScore(it: String): Int {
        return when (it) {
            "-" -> 0
            "X" -> 10
            else -> it.toInt()
        }
    }
}
