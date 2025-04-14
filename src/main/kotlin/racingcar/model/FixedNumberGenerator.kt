package racingcar.model

import kotlin.random.Random

class FixedNumberGenerator(private val number: Int) : NumberGenerator {
    override fun generate() = number
}