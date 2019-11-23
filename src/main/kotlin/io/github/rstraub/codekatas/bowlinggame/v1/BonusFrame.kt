package io.github.rstraub.codekatas.bowlinggame.v1

abstract class BonusFrame(frameScore: String) : Frame(frameScore) {
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
