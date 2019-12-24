package io.github.rstraub.codekatas.mastermind.v1

class Attempt(guess: Code, correct: List<Peg>, misplaced: List<Peg>) {
    private val result = Result(correct.size, misplaced.size)

    val amountCorrect = result.correct

    val amountMisplaced = result.misplaced
}
