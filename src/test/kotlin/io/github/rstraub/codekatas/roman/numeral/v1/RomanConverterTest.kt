package io.github.rstraub.codekatas.roman.numeral.v1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RomanConverterTest {
    @Test
    internal fun `should convert a one to I`() =
        assertConversion(1, "I")

    @Test
    internal fun `should convert a five to V`() =
        assertConversion(5, "V")

    @Test
    internal fun `should convert ten to X`() =
        assertConversion(10, "X")

    @Test
    internal fun `should convert twenty to XX`() =
        assertConversion(20, "XX")

    private fun assertConversion(number: Int, roman: String) {
        val result = RomanConverter().convert(number)
        assertThat(result).isEqualTo(roman)
    }
}
