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
    internal fun `frames without all pins down should count as the number of pins down`() {
        line = Line("1,1|1,1|1,1|1,1|1,1|1,1|1,1|1,1|1,1|1,1")

        assertThat(line.score).isEqualTo(20)
    }

    @Test
    internal fun `a spare should count as ten plus the score of the first throw in the frame after it`() {
        line = Line("5,/|5,/|5,/|5,/|5,/|5,/|5,/|5,/|5,/|5,/,5")

        assertThat(line.score).isEqualTo(150)
    }

    @Test
    internal fun `a strike counts as the 10 plus the score of the next two throws`() {
        line = Line("X|1,2")

        assertThat(line.score).isEqualTo(16)
    }

//    TODO strike followed by a spare
}
