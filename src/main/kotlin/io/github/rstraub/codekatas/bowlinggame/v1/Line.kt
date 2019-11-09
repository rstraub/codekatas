package io.github.rstraub.codekatas.bowlinggame.v1

class Line(scorecard: String) : ScoreProvider {
    private companion object {
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
}
