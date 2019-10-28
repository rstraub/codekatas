package io.github.rstraub.codekatas.bowlinggame.v1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LineTest {
    lateinit var line: Line

    @Test
    internal fun `a - should count as zero`() {
        line = Line("9,-|9,-|9,-|9,-|9,-|9,-|9,-|9,-|9,-|9,-")

        assertThat(line.score).isEqualTo(90)
    }

    @Test
    internal fun `a 'X' should count as ten`() {
        val scoreProvider = Line("X")

        assertThat(scoreProvider.score).isEqualTo(10)
    }
}
