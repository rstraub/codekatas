package io.github.rstraub.codekatas.mastermind.v1

class MasterMind(private val secret: Code) {
    infix fun evaluate(guess: Code) = Result(amountCorrect(guess), amountMisplaced(guess))

    private fun amountCorrect(guess: Code) =
        secret.evaluate(guess).correct.size

    private fun amountMisplaced(guess: Code) =
        secret.evaluate(guess).misplaced.size
}
