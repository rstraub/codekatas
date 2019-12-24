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
    infix fun evaluate(guess: Code): Result {
        return Result(amountCorrect(guess), amountMisplaced(guess))
    }

    private fun amountCorrect(guess: Code) =
        secret.evaluate(guess).correct.size

    private fun amountMisplaced(guess: Code) =
        secret.evaluate(guess).misplaced.size
}

data class Attempt(val correct: List<Peg>, val misplaced: List<Peg>)

data class Code(val pegs: List<Peg>) {
    constructor(vararg colors: Colors) : this(colors.toList().mapIndexed(::Peg))

    fun evaluate(guess: Code) = Attempt(correctPegs(guess), misplacedPegs(guess))

    private fun correctPegs(guess: Code) =
        guess.pegs.filter { it == pegs[it.index] }

    private fun misplacedPegs(guess: Code) =
        guessRemainder(guess)
            .filter { it.color in remainingSecretColors(guess) }

    private fun remainingSecretColors(guess: Code) =
        secretRemainder(guess).map(Peg::color)

    private fun guessRemainder(guess: Code) =
        guess.pegs - correctPegs(guess)

    private fun secretRemainder(guess: Code) =
        pegs - correctPegs(guess)
}

data class Peg(val index: Int, val color: Colors)

data class Result(val correct: Int, val misplaced: Int)
