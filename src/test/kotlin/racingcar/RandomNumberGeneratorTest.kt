package racingcar

import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.assertDoesNotThrow
import racingcar.model.numberGenerator.RandomNumberGenerator

class RandomNumberGeneratorTest {
    @RepeatedTest(100)
    fun `0에서 9 사이의 숫자 중 하나를 뽑는다`() {
        val number = RandomNumberGenerator.generate()
        assertDoesNotThrow { number in 0..9 }
    }
}