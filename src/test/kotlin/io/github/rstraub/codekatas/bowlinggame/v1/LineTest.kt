package io.github.rstraub.codekatas.bowlinggame.v1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class LineTest {
    private lateinit var line: Line

    @Nested
    inner class NumeralThrows {
        @Test
        internal fun `should return the score for a single throw`() {
            line = Line("1")

            assertThat(line.score).isEqualTo(1)
        }

        @Test
        internal fun `should return the score for two throws`() {
            line = Line("12")

            assertThat(line.score).isEqualTo(3)
        }

        @Test
        internal fun `should calculate the score for a scorecard with only numeral throws`() {
            line = Line("12345123451234512345")

            assertThat(line.score).isEqualTo(60)
        }
    }

    @Test
    internal fun `should calculate a "-" as zero points`() {
        line = Line("1-")

        assertThat(line.score).isEqualTo(1)
    }
}
