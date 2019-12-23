package io.github.rstraub.codekatas.roman.numeral.v1

class RomanConverter {
    private val numberToRoman = mapOf(
        10 to "X",
        5 to "V",
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
