package io.github.rstraub.codekatas.bowlinggame.v1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BallThrowTest {
    private lateinit var ballThrow: BallThrow

    @Test
    internal fun `a strike should be ten points`() {
        ballThrow = BallThrow("X")

        assertThat(ballThrow.score).isEqualTo(10)
    }

    @Test
    internal fun `a spare should have a score of ten points`() {
        ballThrow = BallThrow("/")

        assertThat(ballThrow.score).isEqualTo(10)
    }

    @Test
    internal fun `a "-" should have a score of 0`() {
        ballThrow = BallThrow("-")

        assertThat(ballThrow.score).isEqualTo(0)
    }

    @Test
    internal fun `a numeral should be the score for a single throw`() {
        ballThrow = BallThrow("1")

        assertThat(ballThrow.score).isEqualTo(1)
    }
}
