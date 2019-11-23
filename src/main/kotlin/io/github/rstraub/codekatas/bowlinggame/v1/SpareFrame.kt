package io.github.rstraub.codekatas.bowlinggame.v1

internal class SpareFrame(frameScore: String) : BonusFrame(frameScore) {
    override fun calculateBonus(): Int {
        val next = firstBonusThrow() ?: ZERO
        return throwScore(next)
    }
}
