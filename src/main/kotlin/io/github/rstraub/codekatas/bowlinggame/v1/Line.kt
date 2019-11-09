package io.github.rstraub.codekatas.bowlinggame.v1

class Line(scorecard: String) : ScoreProvider {
    private companion object {
        private const val BALL_THROW_DELIMITER = ","
        private const val FRAME_DELIMITER = "|"
    }

    override val score: Int

    init {
        val frames = scorecard
                .split(FRAME_DELIMITER)
                .map { Frame(it) }

        frames.forEachIndexed { index, frame ->
            var nextFrame: Frame? = null
            if (index + 1 < frames.size)
                nextFrame = frames[index + 1]

            frame.nextFrame = nextFrame
        }

        score = frames
                .map(Frame::score)
                .sum()
    }


    private inner class Frame(frameScore: String) : ScoreProvider {
        private val ballThrows: List<String> = frameScore.split(BALL_THROW_DELIMITER)
        private val isSpare: Boolean = ballThrows.contains("/")

        val firstThrow = ballThrows[0]
        val thirdThrow = ballThrows.getOrNull(2)

        var nextFrame: Frame? = null

        override val score: Int
            get() = if (isSpare) {
                calculateSpareScore()
            } else {
                calculatePinScore()
            }

        private fun calculatePinScore(): Int {
            return ballThrows
                    .map(this::throwScore)
                    .sum()
        }

        private fun calculateSpareScore(): Int {
            val isLastFrame = nextFrame == null

            val nextThrow = if (isLastFrame) {
                thirdThrow!!
            } else {
                nextFrame!!.firstThrow
            }

            val bonusScore = throwScore(nextThrow)
            return 10 + bonusScore
        }

        fun throwScore(ballThrow: String) = when (ballThrow) {
            "-" -> 0
            else -> ballThrow.toInt()
        }
    }
}
