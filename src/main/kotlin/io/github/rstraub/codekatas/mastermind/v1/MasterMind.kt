package io.github.rstraub.codekatas.mastermind.v1

enum class Colors {
    RED,
    BLUE,
    YELLOW,
    GREEN,
    PURPLE,
    BLACK
}

class MasterMind(secret: Code) {
    private val secret = secret.pegs

    fun evaluate(guess: Code): Result {
        val correctPegs = correctPegs(guess.pegs)

        return Result(correctPegs.size, 0)
    }

    private fun correctPegs(guess: List<Peg>) =
        guess.filterIndexed { index, peg ->
            peg.color == secret[index].color
        }
}

class Code private constructor(colors: List<Colors>) {
    constructor(vararg colors: Colors) : this(colors.toList())

    val pegs = colors.mapIndexed(::Peg)
}

data class Peg(val index: Int, val color: Colors)

data class Result(val correct: Int, val inWrongPlace: Int)
