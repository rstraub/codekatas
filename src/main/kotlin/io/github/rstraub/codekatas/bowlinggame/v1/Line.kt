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

        linkFrames(frames)

        score = frames
                .map(Frame::score)
                .sum()
    }

    private fun linkFrames(frames: List<Frame>) {
        frames.forEachIndexed { index, frame ->
            if (index + 1 < frames.size)
                frame.nextFrame = frames[index + 1]
        }
    }
}
