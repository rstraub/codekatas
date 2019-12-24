package io.github.rstraub.codekatas.mastermind.v1

import io.github.rstraub.codekatas.mastermind.v1.Colors.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MasterMindTest {
    @Test
    internal fun `should give back 0 correct when all are wrong`() =
        assertGuessResult(
            Result(0, 0),
            secret = Code(RED, RED, RED, RED),
            guess = Code(BLUE, BLUE, BLUE, BLUE)
        )

    @Test
    internal fun `should give back the amount of correct pegs when they are present`() =
        assertGuessResult(
            Result(4, 0),
            secret = Code(RED, RED, RED, RED),
            guess = Code(RED, RED, RED, RED)
        )

    @Test
    internal fun `should give back the misplaced pegs when they are present`() =
        assertGuessResult(
            Result(0, 1),
            secret = Code(YELLOW, RED, BLUE, GREEN),
            guess = Code(BLACK, BLACK, BLACK, YELLOW)
        )

    @Test
    internal fun `should not detect misplaced pegs in the guess when they were already counted as correct ones`() {
        assertGuessResult(
            Result(2, 0),
            secret = Code(RED, RED, YELLOW, YELLOW),
            guess = Code(RED, RED, BLUE, RED)
        )
    }

    @Test
    internal fun `should not count a correct peg in the guess as misplaced as well`() {
        assertGuessResult(
            Result(1, 0),
            secret = Code(RED, RED, YELLOW, YELLOW),
            guess = Code(RED, BLUE, BLUE, BLUE)
        )
    }

    private fun assertGuessResult(
        expected: Result,
        secret: Code,
        guess: Code
    ) {
        val masterMind = MasterMind(secret)

        val result = masterMind evaluate guess

        assertThat(result.amountCorrect).isEqualTo(expected.correct)
        assertThat(result.amountMisplaced).isEqualTo(expected.misplaced)
    }
}
