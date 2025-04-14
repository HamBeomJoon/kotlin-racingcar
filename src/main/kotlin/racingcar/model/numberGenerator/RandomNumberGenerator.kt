package racingcar.model.numberGenerator

import kotlin.random.Random

object RandomNumberGenerator : NumberGenerator {
    override fun generate() = Random.nextInt(0, 10)
}