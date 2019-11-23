package io.github.rstraub.codekatas.bowlinggame.v1

class StrikeFrame(frameScore: String) : BonusFrame(frameScore) {
    override fun calculateScore(): Int {
        val bonus = if (nextFrame is SpareFrame) {
            10
        } else {
            val next = firstBonusThrow() ?: ZERO
            val second = secondBonusThrow() ?: ZERO
            throwScore(next) + throwScore(second)
        }

        return throwScore(STRIKE) + bonus
    }

    private fun secondBonusThrow(): String? {
        return if (isLastFrame()) {
            thirdThrow
        } else {
            return if (nextFrame?.secondThrow != null) {
                nextFrame!!.secondThrow
            } else {
                nextFrame?.nextFrame?.firstThrow
            }
        }
    }
}
