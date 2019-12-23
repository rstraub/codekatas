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

    fun convert(number: Int): String {
        var remainder = number
        var result = ""
        numberToRoman.forEach {
            while (remainder / it.key >= 1) {
                remainder -= it.key
                result += it.value
            }
        }
        return result
    }
}
