package io.github.rstraub.codekatas.mastermind.v1

import io.github.rstraub.codekatas.mastermind.v1.Colors.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MasterMindTest {
    @Test
    internal fun `should give back 0 correct when all are wrong`() =
        assertGuessResult(
            Result(0, 0),
            MasterMind(RED, RED, RED, RED),
            Code(BLUE, BLUE, BLUE, BLUE)
        )

    @Test
    internal fun `should give back 4 correct when all are correct`() =
        assertGuessResult(
            Result(4, 0),
            MasterMind(RED, RED, RED, RED),
            Code(RED, RED, RED, RED)
        )

    @Test
    internal fun `should give back 2 correct when two colors are correct`() =
        assertGuessResult(
            Result(2, 0),
            MasterMind(RED, RED, RED, RED),
            Code(RED, RED, YELLOW, YELLOW)
        )

    @Test
    internal fun `should give back 1 in wrong place when there is a single misplaced peg`() =
        assertGuessResult(
            Result(0, 1),
            MasterMind(YELLOW, RED, BLUE, GREEN),
            Code(BLACK, BLACK, BLACK, YELLOW)
        )
}

private fun assertGuessResult(
    expected: Result,
    mastermind: MasterMind,
    guess: Code
) {
    val result = mastermind.evaluate(guess)

    assertThat(result.correct).isEqualTo(expected.correct)
    assertThat(result.inWrongPlace).isEqualTo(expected.inWrongPlace)
}
