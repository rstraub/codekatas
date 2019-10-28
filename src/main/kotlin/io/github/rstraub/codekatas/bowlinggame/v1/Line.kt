package io.github.rstraub.codekatas.bowlinggame.v1

class Line(scorecard: String): ScoreProvider {
    private companion object {
        private const val BALL_THROW_DELIMITER = ","
        private const val FRAME_DELIMITER = "|"
    }

    override val score: Int

    init {
        score = scorecard
                .split(FRAME_DELIMITER)
                .map(::Frame)
                .map(Frame::score)
                .sum()
    }


    private inner class Frame(frameScore: String): ScoreProvider {
        override val score: Int = frameScore.split(BALL_THROW_DELIMITER)
                .map(::BallThrow)
                .map(BallThrow::score)
                .sum()

    }

    private inner class BallThrow(throwScore: String): ScoreProvider {
        override val score: Int = when (throwScore) {
            "X" -> 10
            "-" -> 0
            else -> throwScore.toInt()
        }
    }
}
