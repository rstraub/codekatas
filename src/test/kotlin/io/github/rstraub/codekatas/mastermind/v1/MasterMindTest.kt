package io.github.rstraub.codekatas.mastermind.v1

import io.github.rstraub.codekatas.mastermind.v1.Colors.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MasterMindTest {
    @Test
    internal fun `should give back 0 correct when all are wrong`() =
        assertGuessResult(
            listOf(RED, RED, RED, RED),
            listOf(BLUE, BLUE, BLUE, BLUE),
            Result(0, 0)
        )

    @Test
    internal fun `should give back 4 correct when all are correct`() =
        assertGuessResult(
            listOf(RED, RED, RED, RED),
            listOf(RED, RED, RED, RED),
            Result(4, 0)
        )

    @Test
    internal fun `should give back 2 correct when two colors are correct`() =
        assertGuessResult(
            listOf(RED, RED, RED, RED),
            listOf(RED, RED, YELLOW, YELLOW),
            Result(2, 0)
        )

    @Test
    internal fun `should give back 1 in wrong place when there is a single misplaced peg`() =
        assertGuessResult(
            listOf(YELLOW, RED, BLUE, GREEN),
            listOf(BLACK, BLACK, BLACK, YELLOW),
            Result(0, 1)
        )
}

private fun assertGuessResult(secret: List<Colors>, guess: List<Colors>, expected: Result) {
    val mastermind = MasterMind(secret)

    val result = mastermind evaluate guess

    assertThat(result.correct).isEqualTo(expected.correct)
    assertThat(result.inWrongPlace).isEqualTo(expected.inWrongPlace)
}
