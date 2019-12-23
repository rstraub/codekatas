package io.github.rstraub.codekatas.mastermind.v1

enum class Colors {
    RED,
    BLUE,
    YELLOW
}

class MasterMind(val secret: List<Colors>) {
    infix fun compare(guess: List<Colors>) =
        Result(numberOfCorrectPegs(guess), 0)

    private fun numberOfCorrectPegs(guess: List<Colors>) =
        guess.foldIndexed(0) { index, correct, color ->
            if (secret[index] == color)
                correct + 1
            else
                correct
        }
}

data class Result(val correct: Int, val inWrongPlace: Int)
