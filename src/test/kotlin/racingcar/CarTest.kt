package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.numberGenerator.FixedNumberGenerator
import racingcar.model.numberGenerator.RandomNumberGenerator

class CarTest {
    @Test
    fun `자동차는 이름을 가진다`() {
        val car1 = Car("미플", RandomNumberGenerator)
        assertThat(car1.name).isEqualTo("미플")
    }

    @Test
    fun `자동차는 위치를 가진다`() {
        val car1 = Car("미플", RandomNumberGenerator)
        assertThat(car1.position).isEqualTo(0)
    }

    @Test
    fun `무작위 값이 4이상이면 자동차는 전진한다`() {
        val car1 = Car("미플", FixedNumberGenerator(4))
        car1.moveOrStop()
        assertThat(car1.position).isEqualTo(1)
    }

    @Test
    fun `무작위 값이 4미만이면 자동차는 전진한다`() {
        val car1 = Car("미플", FixedNumberGenerator(3))
        car1.moveOrStop()
        assertThat(car1.position).isEqualTo(0)
    }
}
