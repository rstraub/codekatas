package io.github.rstraub.codekatas.bowlinggame.v1

class SpareFrame(frameScore: String) : BonusFrame(frameScore) {
    override fun calculateScore(): Int {
        val next = firstBonusThrow() ?: ZERO
        val bonus = throwScore(next)
        return 10 + bonus
    }
}
