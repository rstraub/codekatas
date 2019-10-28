package io.github.rstraub.codekatas.bowlinggame.v1

class Line(scorecard: String) {
    companion object {
        private const val BALL_THROW_DELIMITER = ","
    }

    val score: Int

    init {
        score = scorecard.split(BALL_THROW_DELIMITER)
                .map(this::getThrowScore)
                .sum()
    }

    private fun getThrowScore(scorecard: String): Int {
        return when (scorecard) {
            "X" -> 10
            "-" -> 0
            else -> scorecard.toInt()
        }
    }
}
