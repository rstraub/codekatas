package io.github.rstraub.codekatas.mastermind.v1

class MasterMind(private val secret: Code) {
    infix fun evaluate(guess: Code) = secret.evaluate(guess)
}
