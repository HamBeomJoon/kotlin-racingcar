package racingcar.model

class FixedNumberGenerator(private val number: Int) : NumberGenerator {
    override fun generate() = number
}