package racingcar.model

import kotlin.random.Random

object RandomNumberGenerator {
    fun generate() = Random.nextInt(0, 10)
}