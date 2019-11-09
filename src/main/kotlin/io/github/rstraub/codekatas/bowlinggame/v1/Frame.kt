package io.github.rstraub.codekatas.bowlinggame.v1

class Frame(frameScore: String) : ScoreProvider {
    private companion object {
        private const val BALL_THROW_DELIMITER = ","
        private const val SPARE = "/"
        private const val ZERO = "-"
        private const val STRIKE = "X"
    }

    private val ballThrows: List<String> = frameScore.split(BALL_THROW_DELIMITER)
    private val firstThrow = ballThrows[0]
    private val thirdThrow = ballThrows.getOrNull(2)

    // TODO set on construction
    var nextFrame: Frame? = null

    override val score: Int
        get() = if (isSpare()) {
            calculateSpareScore()
        } else {
            calculatePinScore()
        }

    private fun isSpare() = ballThrows.contains(SPARE)
    private fun isLastFrame() = nextFrame == null

    private fun calculatePinScore(): Int {
        return ballThrows
                .map(this::throwScore)
                .sum()
    }

    private fun calculateSpareScore(): Int {
        val next = nextThrow(1) ?: ZERO
        val bonusScore = throwScore(next)
        return 10 + bonusScore
    }

    private fun nextThrow(index: Int): String? {
        return if (isLastFrame()) {
            ballThrows.getOrNull(index + 1)
        } else {
            nextFrame?.firstThrow
        }
    }

    private fun throwScore(ballThrow: String): Int {
        return when (ballThrow) {
            ZERO -> 0
            STRIKE -> 10
            else -> ballThrow.toInt()
        }
    }
}
