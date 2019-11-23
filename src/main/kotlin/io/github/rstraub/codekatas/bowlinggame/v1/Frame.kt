package io.github.rstraub.codekatas.bowlinggame.v1

open class Frame(frameScore: String) : ScoreProvider {
    protected companion object {
        private const val BALL_THROW_DELIMITER = ","
        const val SPARE = "/"
        const val ZERO = "-"
        const val STRIKE = "X"
    }

    private val ballThrows: List<String> = frameScore.split(BALL_THROW_DELIMITER)
    val firstThrow = ballThrows[0]
    val secondThrow = ballThrows.getOrNull(1)
    val thirdThrow = ballThrows.getOrNull(2)

    private val isSpare = ballThrows.contains(SPARE)

    var nextFrame: Frame? = null

    override val score: Int
        get() = calculateScore()

    protected fun isLastFrame() = nextFrame == null

    protected open fun calculateScore(): Int {
        return ballThrows
            .map(this::throwScore)
            .sum()
    }

    protected fun firstBonusThrow(): String? {
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

    protected fun throwScore(ballThrow: String): Int {
        return when (ballThrow) {
            ZERO -> 0
            STRIKE -> 10
            else -> ballThrow.toInt()
        }
    }
}
