package io.github.rstraub.codekatas.bowlinggame.v1

class SpareFrame(frameScore: String) : BonusFrame(frameScore) {
    override fun calculateScore(): Int {
        return 10 + calculateBonus()
    }

    private fun calculateBonus(): Int {
        val next = firstBonusThrow() ?: ZERO
        return throwScore(next)
    }
}
