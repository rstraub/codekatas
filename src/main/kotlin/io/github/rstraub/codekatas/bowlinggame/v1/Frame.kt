package io.github.rstraub.codekatas.bowlinggame.v1

class Frame(ballThrows: String) {
    val score: Int

    init {
       score = throwToScore(ballThrows)
    }

    private fun throwToScore(it: String) = when (it) {
        "-" -> 0
        "X" -> 10
        else -> it.toInt()
    }
}
