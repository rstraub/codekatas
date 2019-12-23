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

        return Result(correctPegs.size, inWrongPlace(guessRemainder(guess), secretRemainder(guess)))
    }

    private fun correctPegs(guess: List<Peg>) =
        guess.filterIndexed { index, peg -> peg == secret.pegs[index] }

    private fun inWrongPlace(
        guessRemainder: Code,
        secretRemainder: Code
    ): Int {
        val secretColors = secretRemainder.asColors()
        return guessRemainder
            .asColors()
            .fold(0) { acc, color ->
                if (color in secretColors)
                    acc + 1
                else
                    acc
            }
    }

    private fun guessRemainder(guess: Code) =
        Code(guess.pegs - correctPegs(guess.pegs))

    private fun secretRemainder(guess: Code) =
        Code(secret.pegs - correctPegs(guess.pegs))
}

data class Code(val pegs: List<Peg>) {
    constructor(vararg colors: Colors) : this(colors.toList().mapIndexed(::Peg))

    fun asColors() = pegs.map(Peg::color)
}

data class Peg(val index: Int, val color: Colors)

data class Result(val correct: Int, val inWrongPlace: Int)
