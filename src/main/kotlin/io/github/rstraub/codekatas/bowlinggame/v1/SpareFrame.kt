package io.github.rstraub.codekatas.bowlinggame.v1

class SpareFrame(frameScore: String) : Frame(frameScore) {
    override fun calculateScore(): Int {
        val next = nextThrow() ?: ZERO
        val bonus = throwScore(next)
        return 10 + bonus
    }
}
