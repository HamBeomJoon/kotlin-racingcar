package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {
    @Test
    fun `자동차는 이름을 가진다`() {
        val car1 = Car("미플")
        assertThat(car1.name).isEqualTo("미플")
    }

    @Test
    fun `자동차는 위치를 가진다`() {
        val car1 = Car("미플")
        assertThat(car1.position).isEqualTo(0)
    }

    @Test
    fun `무작위 값이 4이상이면 자동차는 전진한다`() {
        val car1 = Car("미플")
        val randomNumber = 4
        car1.move(randomNumber)
        assertThat(car1.position).isEqualTo(1)
    }

    @Test
    fun `무작위 값이 4미만이면 자동차는 전진한다`() {
        val car1 = Car("미플")
        val randomNumber = 3
        car1.move(randomNumber)
        assertThat(car1.position).isEqualTo(0)
    }
}
