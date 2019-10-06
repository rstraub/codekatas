package io.github.rstraub.codekatas.bowlinggame.v1

class Frame(throwScores: String): ScoreProvider {
    override val score: Int
    private val ballThrows: List<BallThrow> = throwScoreToBallThrows(throwScores)

    init {
        score = ballThrows.map { it.score }
                .sum()
    }

    private fun throwScoreToBallThrows(throwScores: String): List<BallThrow> {
        return throwScores.asSequence()
                .map(Char::toString)
                .map(::BallThrow)
                .toList()
    }
}
