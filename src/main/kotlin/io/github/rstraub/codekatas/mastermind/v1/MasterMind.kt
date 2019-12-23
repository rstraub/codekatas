package io.github.rstraub.codekatas.mastermind.v1

enum class Colors {
    RED,
    BLUE,
    YELLOW,
    GREEN,
    PURPLE,
    BLACK
}

class MasterMind(private val secret: Code) {
    fun evaluate(guess: Code): Result {
        val correctPegs = correctPegs(guess.pegs)

        val guessRemainder = guess.pegs - correctPegs
        val secretRemainder = secret.pegs - correctPegs

        return Result(correctPegs.size, inWrongPlace(guessRemainder, secretRemainder))
    }

    private fun inWrongPlace(
        guessRemainder: List<Peg>,
        secretRemainder: List<Peg>
    ): Int {
        val secretColors = secretRemainder.map(Peg::color)
        return guessRemainder
            .map(Peg::color)
            .fold(0) { acc, color ->
                if (color in secretColors)
                    acc + 1
                else
                    acc
            }
    }

    private fun correctPegs(guess: List<Peg>) =
        guess.filterIndexed { index, peg ->
            peg.color == secret.pegs[index].color
        }
}

class Code private constructor(colors: List<Colors>) {
    constructor(vararg colors: Colors) : this(colors.toList())

    val pegs = colors.mapIndexed(::Peg)
}

data class Peg(val index: Int, val color: Colors)

data class Result(val correct: Int, val inWrongPlace: Int)
