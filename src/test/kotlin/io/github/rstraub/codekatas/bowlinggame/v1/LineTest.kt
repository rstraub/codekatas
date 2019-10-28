package io.github.rstraub.codekatas.bowlinggame.v1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class LineTest {
    @Test
    internal fun `a - should count as zero`() {
        val line = Line("-,-")

        assertThat(line.score).isEqualTo(0)
    }

    @Test
    internal fun `a 'X' should count as ten`() {
        val line = Line("X")

        assertThat(line.score).isEqualTo(10)
    }

    @Test
    internal fun `a number should count as the number of pins hit`() {
        val line = Line("1,2")

        assertThat(line.score).isEqualTo(3)
    }

    @Test
    @Disabled
    internal fun `each frame should have a score`() {
        val line = Line("1,2|1,2")

        assertThat(line.score).isEqualTo(6)
    }
}
