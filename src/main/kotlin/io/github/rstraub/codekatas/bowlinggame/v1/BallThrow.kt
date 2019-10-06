package io.github.rstraub.codekatas.bowlinggame.v1

class BallThrow(throwEntry: String) {
    val score: Int

    init {
        score = throwToScore(throwEntry)
    }

    private fun throwToScore(entry: String) = when (entry) {
        "-" -> 0
        "/", "X" -> 10
        else -> entry.toInt()
    }
}
