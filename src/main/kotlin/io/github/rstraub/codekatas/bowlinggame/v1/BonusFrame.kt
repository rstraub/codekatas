package io.github.rstraub.codekatas.bowlinggame.v1

internal abstract class BonusFrame(frameScore: String) : Frame(frameScore) {
    override fun calculateScore() = 10 + calculateBonus()

    protected abstract fun calculateBonus(): Int

    protected fun firstBonusThrow(): String? {
        return if (isLastFrame()) {
            val isSpare = secondThrow == SPARE
            return if (isSpare) {
                thirdThrow
            } else {
                secondThrow
            }
        } else {
            nextFrame?.firstThrow
        }
    }
}
