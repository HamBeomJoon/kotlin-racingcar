package racingcar.model.numberGenerator

class FixedNumberGenerator(private val number: Int) : NumberGenerator {
    override fun generate(): Int = number
}
