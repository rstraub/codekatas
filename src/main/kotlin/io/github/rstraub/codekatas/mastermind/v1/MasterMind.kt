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

    private fun amountMisplaced(guess: Code) =
        misplacedPegs(guess).size

    private fun misplacedPegs(guess: Code) =
        guessRemainder(guess)
            .filter { it.color in remainingSecretColors(guess) }

    private fun remainingSecretColors(guess: Code) =
        secretRemainder(guess).map(Peg::color)

    private fun guessRemainder(guess: Code) =
        guess.pegs - correctPegs(guess)

    private fun secretRemainder(guess: Code) =
        secret.pegs - correctPegs(guess)
}

data class Code(val pegs: List<Peg>) {
    constructor(vararg colors: Colors) : this(colors.toList().mapIndexed(::Peg))
}

data class Peg(val index: Int, val color: Colors)

data class Result(val correct: Int, val misplaced: Int)
