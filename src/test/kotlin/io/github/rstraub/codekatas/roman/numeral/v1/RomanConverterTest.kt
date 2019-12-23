package io.github.rstraub.codekatas.roman.numeral.v1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RomanConverterTest {
    @Test
    internal fun `should convert a one to I`() {
        val result = RomanConverter().convert(1)
        assertThat(result).isEqualTo("I")
    }

    @Test
    internal fun `should convert a five to V`() {
        val result = RomanConverter().convert(5)
        assertThat(result).isEqualTo("V")
    }
}
