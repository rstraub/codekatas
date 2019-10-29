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
    internal fun `a spare should count as ten plus the score of the first throw in the frame after it`() {
        line = Line("1,/|1,2")

        assertThat(line.score).isEqualTo(14)
    }
}
