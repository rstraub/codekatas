package io.github.rstraub.codekatas.bowlinggame.v1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LineTest {
    lateinit var line: Line

    @Test
    internal fun `a - should count as zero`() {
        line = Line("-,-|-,-")

        assertThat(line.score).isEqualTo(0)
    }

    @Test
    internal fun `a 'X' should count as ten`() {
        val scoreProvider = Line("X")

        assertThat(scoreProvider.score).isEqualTo(10)
    }

    @Test
    internal fun `a number should count as the number of pins hit`() {
        val scoreProvider = Line("1,2|1,2")

        assertThat(scoreProvider.score).isEqualTo(6)
    }
}
