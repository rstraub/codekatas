package io.github.rstraub.codekatas.mastermind.v1

enum class Colors {
    RED,
    BLUE,
    YELLOW
}

class MasterMind(val secret: List<Colors>) {
    infix fun compare(guess: List<Colors>): Result {
        var correct = 0

        guess.forEachIndexed { index, color ->
            if (secret[index] == color)
                correct++
        }

        return Result(correct, 0)
    }
}

data class Result(val correct: Int, val inWrongPlace: Int)
