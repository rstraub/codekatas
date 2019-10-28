package io.github.rstraub.codekatas.bowlinggame.v1

class Line(scorecard: String) {
    private companion object {
        private const val BALL_THROW_DELIMITER = ","
    }

    val score: Int

    init {
        score = scorecard.split(BALL_THROW_DELIMITER)
                .map(::BallThrow)
                .map{ it.score }
                .sum()
    }



    private inner class BallThrow(throwScore: String) {
        var score: Int

        init {
            score = calculateScore(throwScore)
        }

        private fun calculateScore(scorecard: String): Int {
            return when (scorecard) {
                "X" -> 10
                "-" -> 0
                else -> scorecard.toInt()
            }
        }
    }
}
