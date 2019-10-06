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
}
