package racingcar.model

import racingcar.model.numberGenerator.NumberGenerator
import racingcar.model.numberGenerator.RandomNumberGenerator

class Car(val name: String, private val strategy: NumberGenerator = RandomNumberGenerator) {
    var position = 0
        private set

    fun moveOrStop() {
        if (judgeMove()) position++
    }

    private fun judgeMove(): Boolean {
        return strategy.generate() >= 4
    }
}