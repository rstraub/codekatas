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
    internal fun `should convert 36 to XXXVI`() =
        assertConversion(36, "XXXVI")

    @Test
    internal fun `should convert four to IV`() =
        assertConversion(4,"IV")

    @Test
    internal fun `should convert nine to IX`() =
        assertConversion(9, "IX")

    @Test
    internal fun `should convert 49 to XLIX`() =
        assertConversion(49, "XLIX")

    @Test
    internal fun `should convert 0 to empty string`() =
        assertConversion(0, "")

    private fun assertConversion(number: Int, roman: String) {
        val result = RomanConverter().convert(number)
        assertThat(result).isEqualTo(roman)
    }
}
