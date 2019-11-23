package io.github.rstraub.codekatas.bowlinggame.v1

internal class SpareFrame(frameScore: String) : BonusFrame(frameScore) {
    override fun calculateBonus(): Int {
        val bonusThrow = firstBonusThrow()

        return if (bonusThrow == null) {
            0
        } else {
            throwScore(bonusThrow)
        }
    }
}
