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
    fun evaluate(guess: Code) = Result(amountCorrect(guess), amountMisplaced(guess))

    private fun amountCorrect(guess: Code) =
        correctPegs(guess).size

    private fun correctPegs(guess: Code) =
        guess.pegs.filterIndexed { index, peg -> peg == secret.pegs[index] }

    private fun amountMisplaced(
        guess: Code
    ): Int {
        val secretColors = secretRemainder(guess).asColors()
        return guessRemainder(guess)
            .asColors()
            .fold(0) { acc, color ->
                if (color in secretColors)
                    acc + 1
                else
                    acc
            }
    }

    private fun guessRemainder(guess: Code) =
        Code(guess.pegs - correctPegs(guess))

    private fun secretRemainder(guess: Code) =
        Code(secret.pegs - correctPegs(guess))
}

data class Code(val pegs: List<Peg>) {
    constructor(vararg colors: Colors) : this(colors.toList().mapIndexed(::Peg))

    fun asColors() = pegs.map(Peg::color)
}

data class Peg(val index: Int, val color: Colors)

data class Result(val correct: Int, val misplaced: Int)
