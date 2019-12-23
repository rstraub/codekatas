package io.github.rstraub.codekatas.mastermind.v1

enum class Colors {
    RED,
    BLUE,
    YELLOW,
    GREEN,
    PURPLE,
    BLACK
}

class MasterMind(vararg secret: Colors) {
    private val secret = secret
        .toList()
        .mapIndexed(::Peg)

    fun evaluate(guess: Code): Result {
        val guessPegs = guess.colors.mapIndexed(::Peg)

        return Result(correctPegs(guessPegs), 0)
    }

    private fun correctPegs(guess: List<Peg>) =
        guess.foldIndexed(0) { index, correct, peg ->
            if (secret[index].color == peg.color)
                correct + 1
            else
                correct
        }
}

data class Code(val colors: List<Colors>) {
    constructor(vararg colors: Colors) : this(colors.toList())
}

data class Peg(val index: Int, val color: Colors)

data class Result(val correct: Int, val inWrongPlace: Int)
