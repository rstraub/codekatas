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
    private val secondThrow = ballThrows.getOrNull(1)
    private val thirdThrow = ballThrows.getOrNull(2)

    private val isSpare = ballThrows.contains(SPARE)
    private val isStrike = firstThrow == STRIKE

    // TODO set on construction
    var nextFrame: Frame? = null

    override val score: Int
        get() = when {
            isSpare -> calculateSpareScore()
            isStrike -> calculateStrikeScore()
            else -> calculatePinsDown()
        }

    private fun isLastFrame() = nextFrame == null

    private fun calculatePinsDown(): Int {
        return ballThrows
                .map(this::throwScore)
                .sum()
    }

    private fun calculateSpareScore(): Int {
        val next = nextThrow() ?: ZERO
        return throwScore(SPARE) + throwScore(next)
    }

    private fun calculateStrikeScore(): Int {
        val next = nextThrow() ?: ZERO
        val second = throwAfterNext() ?: ZERO
        return throwScore(STRIKE) + throwScore(next) + throwScore(second)
    }

    private fun nextThrow(): String? {
        return if (isLastFrame()) {
            return if (isSpare) {
                thirdThrow
            } else {
                secondThrow
            }
        } else {
            nextFrame?.firstThrow
        }
    }

    private fun throwAfterNext(): String? {
        return "1"
    }

    private fun throwScore(ballThrow: String): Int {
        return when (ballThrow) {
            ZERO -> 0
            STRIKE -> 10
            SPARE -> 10
            else -> ballThrow.toInt()
        }
    }
}
