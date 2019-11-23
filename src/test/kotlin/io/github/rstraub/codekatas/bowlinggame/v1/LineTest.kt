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
    internal fun `a spare should not get bonus score if the next throw is zero`() {
        line = Line("-,/|-,1")

        assertThat(line.score).isEqualTo(11)
    }

    @Test
    internal fun `a strike counts as the 10 plus the score of the next two throws`() {
        line = Line("X|X|X|X|X|X|X|X|X|X,X,X")

        assertThat(line.score).isEqualTo(300)
    }

    @Test
    internal fun `a strike followed by a spare should count as 20`() {
        line = Line("X|6,/|1,1")

        assertThat(line.score).isEqualTo(33)
    }

    @Test
    internal fun `a strike followed by zeroes count as just the strike`() {
        line = Line("X|-,-")

        assertThat(line.score).isEqualTo(10)
    }
}
