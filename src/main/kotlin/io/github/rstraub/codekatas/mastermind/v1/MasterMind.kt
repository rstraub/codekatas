package io.github.rstraub.codekatas.mastermind.v1

enum class Colors {
    RED,
    BLUE,
    YELLOW,
    GREEN,
    PURPLE,
    BLACK
}

class MasterMind(val secret: List<Colors>) {
    infix fun evaluate(guess: List<Colors>): Result {
        val guessPegs = guess.mapIndexed(::Peg)

        return Result(correctPegs(guessPegs), 0)
    }

    private fun correctPegs(guess: List<Peg>) =
        guess.foldIndexed(0) { index, correct, peg ->
            if (secret[index] == peg.color)
                correct + 1
            else
                correct
        }
}

data class Peg(val index: Int, val color: Colors)

data class Result(val correct: Int, val inWrongPlace: Int)
