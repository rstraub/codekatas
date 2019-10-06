package io.github.rstraub.codekatas.bowlinggame.v1

class Line(scorecard: String): ScoreProvider {
    override val score: Int

    init {
        score = scorecard.asSequence()
                .map(Char::toString)
                .map(::Frame)
                .map(Frame::score)
                .reduce { acc, frameScore -> acc + frameScore }
    }
}
