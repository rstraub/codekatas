package io.github.rstraub.codekatas.mastermind.v1

import io.github.rstraub.codekatas.mastermind.v1.Colors.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MasterMindTest {
    @Test
    internal fun `should give back 0 correct when all are wrong`() {
        val mastermind = MasterMind(listOf(RED, RED, RED, RED))
        val guess = listOf(BLUE, BLUE, BLUE, BLUE)

        val result = mastermind evaluate guess

        assertThat(result.correct).isEqualTo(0)
        assertThat(result.inWrongPlace).isEqualTo(0)
    }

    @Test
    internal fun `should give back 4 correct when all are correct`() {
        val mastermind = MasterMind(listOf(RED, RED, RED, RED))
        val guess = listOf(RED, RED, RED, RED)

        val result = mastermind evaluate guess

        assertThat(result.correct).isEqualTo(4)
        assertThat(result.inWrongPlace).isEqualTo(0)
    }

    @Test
    internal fun `should give back 2 correct when two colors are correct`() {
        val mastermind = MasterMind(listOf(RED, RED, RED, RED))
        val guess = listOf(RED, RED, YELLOW, YELLOW)

        val result = mastermind evaluate guess

        assertThat(result.correct).isEqualTo(2)
        assertThat(result.inWrongPlace).isEqualTo(0)
    }

    @Test
    internal fun `should give back 1 in wrong place when there is a single misplaced peg`() {
        val mastermind = MasterMind(listOf(YELLOW, RED, BLUE, GREEN))
        val guess = listOf(BLACK, BLACK, BLACK, YELLOW)

        val result = mastermind evaluate guess

        assertThat(result.correct).isEqualTo(0)
        assertThat(result.inWrongPlace).isEqualTo(1)
    }
}
