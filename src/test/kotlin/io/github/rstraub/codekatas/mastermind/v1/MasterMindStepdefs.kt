package io.github.rstraub.codekatas.mastermind.v1;

import io.cucumber.java8.En
import io.github.rstraub.codekatas.mastermind.v1.Colors.BLACK
import io.github.rstraub.codekatas.mastermind.v1.Colors.BLUE
import io.github.rstraub.codekatas.mastermind.v1.Colors.RED
import io.github.rstraub.codekatas.mastermind.v1.Colors.YELLOW
import org.assertj.core.api.Assertions.assertThat

internal class MasterMindStepdefs() : En {
    private val secret = Code(RED, RED, RED, BLACK)
    private val masterMind = MasterMind(secret)
    private lateinit var guess: Code
    private lateinit var attempt: Attempt

    init {
        Given("All pegs are wrong") {
            guess = Code(BLUE, BLUE, BLUE, BLUE)
        }

        Given("All pegs are correct") {
            guess = Code(RED, RED, RED, BLACK)
        }

        Given("A misplaced peg") {
            guess = Code(BLACK, YELLOW, YELLOW, YELLOW)
        }

        When("The guess is evaluated") {
            attempt = masterMind evaluate guess
        }

        Then("The result is {int} correct and {int} misplaced pegs") { correct: Int, misplaced: Int ->
            assertThat(attempt.amountCorrect).isEqualTo(correct)
            assertThat(attempt.amountMisplaced).isEqualTo(misplaced)
        }
    }
}
