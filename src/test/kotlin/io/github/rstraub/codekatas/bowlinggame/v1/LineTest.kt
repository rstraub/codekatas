package io.github.rstraub.codekatas.bowlinggame.v1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class LineTest {
    private lateinit var line: Line

    @Nested
    inner class RegularScorecard {
        @BeforeEach
        internal fun setUp() {
            line = Line("12345123451234512345")
        }

        @Test
        internal fun `should contain frames`() {
            assertThat(line).isNotNull
            assertThat(line.frames).isNotNull
        }

        @Test
        internal fun `should have a frame for each two throws`() {
            assertThat(line.frames.size).isEqualTo(10)
        }
    }

    @Test
    internal fun `should have the the amount of frames for an incomplete scorecard`() {
        line = Line("12")

        assertThat(line.frames.size).isEqualTo(1)
    }
}
