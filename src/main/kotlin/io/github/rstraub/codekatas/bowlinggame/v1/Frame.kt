package io.github.rstraub.codekatas.bowlinggame.v1

class Frame(throwScores: String): ScoreProvider {
    override val score: Int
    private val ballThrows: List<BallThrow> = throwScoreToBallThrows(throwScores)

    init {
        val totalScore = ballThrows.map { it.score }
                .sum()

        score = if (totalScore > 10)
            10
        else
            totalScore
    }

    private fun throwScoreToBallThrows(throwScores: String): List<BallThrow> {
        return throwScores.asSequence()
                .map(Char::toString)
                .map(::BallThrow)
                .toList()
    }
}
