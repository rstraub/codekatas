package io.github.rstraub.codekatas.bowlinggame.v1

class Line(private val scorecard: String) {
    val frames: List<String>

    init {
        frames = mutableListOf()
    }
}
