package io.github.rstraub.codekatas.roman.numeral.v1

class RomanConverter {
    fun convert(number: Int): String {
        var remainder = number
        var result = ""
        while (remainder > 0) {
            result += when {
                number % 10 == 0 -> {
                    remainder -= 10
                    "X"
                }
                number % 5 == 0 -> {
                    remainder -= 5
                    "V"
                }
                else -> {
                    remainder -= 1
                    "I"
                }
            }
        }

        return result
    }
}
