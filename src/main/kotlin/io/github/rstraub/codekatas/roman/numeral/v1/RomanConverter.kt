package io.github.rstraub.codekatas.roman.numeral.v1

class RomanConverter {
    private val numberToRoman = mapOf(
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    fun convert(number: Int): String =
        if (number == 0) ""
        else
            highestNumeral(number) + convert(number - highestNumber(number))

    private fun highestNumber(number: Int) = highestEntry(number).key

    private fun highestNumeral(number: Int) = highestEntry(number).value

    private fun highestEntry(number: Int) =
        numberToRoman.entries.first { number / it.key >= 1 }
}
