package io.github.rstraub.codekatas.bowlinggame.v1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FrameTest {
    private lateinit var frame: Frame

    @Test
    internal fun `the score should be the sum of its throws if its a numeral`() {
        frame = Frame("11")

        assertThat(frame.score).isEqualTo(2)
    }

    @Test
    internal fun `an empty frame should be zero`() {
        frame = Frame("--")

        assertThat(frame.score).isEqualTo(0)
    }

    @Test
    internal fun `a strike should be ten points`() {
        frame = Frame("X")

        assertThat(frame.score).isEqualTo(10)
    }

    @Test
    internal fun `a spare should be ten points in total`() {
        frame = Frame("2/")

        assertThat(frame.score).isEqualTo(10)
    }
}
