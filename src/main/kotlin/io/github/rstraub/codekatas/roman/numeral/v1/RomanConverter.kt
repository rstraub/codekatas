package io.github.rstraub.codekatas.roman.numeral.v1

class RomanConverter {
    fun convert(number: Int) =
        when (number) {
            20 -> "XX"
            10 -> "X"
            5 -> "V"
            else -> "I"
        }
}
