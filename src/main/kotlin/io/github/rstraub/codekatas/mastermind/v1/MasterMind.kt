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

    infix fun evaluate(guess: Code) =
        Result(amountCorrect(guess.pegs), amountMisplaced(guess.pegs))

    private fun amountCorrect(guess: List<Peg>) =
        correctPegs(guess).size

    private fun correctPegs(guess: List<Peg>) =
        guess.filter { it == secret[it.index] }

    private fun amountMisplaced(guess: List<Peg>) =
        misplacedPegs(guess).size

    private fun misplacedPegs(guess: List<Peg>) =
        guessRemainder(guess)
            .filter { it.color in remainingSecretColors(guess) }

    private fun remainingSecretColors(guess: List<Peg>) =
        secretRemainder(guess).map(Peg::color)

    private fun guessRemainder(guess: List<Peg>) =
        guess - correctPegs(guess)

    private fun secretRemainder(guess: List<Peg>) =
        secret - correctPegs(guess)
}

data class Code(val pegs: List<Peg>) {
    constructor(vararg colors: Colors) : this(colors.toList().mapIndexed(::Peg))
}

data class Peg(val index: Int, val color: Colors)

data class Result(val correct: Int, val misplaced: Int)
