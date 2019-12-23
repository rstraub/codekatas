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
        val remainder = guess.pegs - correctPegs

        val secretColors = secret.map(Peg::color)
        val inWrongPlace = remainder
            .map(Peg::color)
            .fold(0) { acc, color ->
                if(color in secretColors)
                    acc + 1
                else
                    acc
            }

        return Result(correctPegs.size, inWrongPlace)
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
