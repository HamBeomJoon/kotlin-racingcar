package racingcar.model

class Car(val name: String, private val strategy: NumberGenerator) {
    var position = 0
        private set

    fun moveOrStop() {
        if (judgeMove()) position++
    }

    private fun judgeMove(): Boolean {
        return strategy.generate() >= 4
    }
}