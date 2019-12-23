package io.github.rstraub.codekatas.roman.numeral.v1

class RomanConverter {
    fun convert(number: Int): String {
        if (number == 5)
            return "V"
        return "I"
    }
}
