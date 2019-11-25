package io.github.rstraub.codekatas.bowlinggame.v1

internal open class Frame(frameScore: String) : ScoreProvider {
    companion object {
        private const val BALL_THROW_DELIMITER = ","
        const val SPARE = "/"
        const val ZERO = "-"
        const val STRIKE = "X"

        fun isSpare(frameScore: String) = frameScore.contains(SPARE)
        fun isStrike(frameScore: String) = frameScore.startsWith(STRIKE)
    }

    private val ballThrows: List<String> = frameScore.split(BALL_THROW_DELIMITER)
    val firstThrow = ballThrows[0]
    val secondThrow = ballThrows.getOrNull(1)
    val thirdThrow = ballThrows.getOrNull(2)

    var nextFrame: Frame? = null

    override val score: Int
        get() = calculateScore()

    protected fun isLastFrame() = nextFrame == null

    protected open fun calculateScore(): Int {
        return ballThrows
            .map(this::throwScore)
            .sum()
    }

    protected fun throwScore(ballThrow: String): Int {
        return when (ballThrow) {
            ZERO -> 0
            STRIKE -> 10
            else -> ballThrow.toInt()
        }
    }
}
