package io.github.rstraub.codekatas.mastermind.v1

class Code(first: Colors, second: Colors, third: Colors, fourth: Colors) {
    private val pegs = listOf(first, second, third, fourth).mapIndexed(::Peg)

    fun evaluate(guess: Code) =
        Attempt(correctPegs(guess), misplacedPegs(guess))

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
