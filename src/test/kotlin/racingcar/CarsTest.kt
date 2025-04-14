package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.Cars
import racingcar.model.numberGenerator.FixedNumberGenerator
import racingcar.model.numberGenerator.RandomNumberGenerator

class CarsTest {
    @Test
    fun `모든 자동차가 한 번씩 이동한다`() {
        // given
        val names = listOf("pobi", "woni", "jun")
        val cars = Cars(names, FixedNumberGenerator(5))

        // when
        cars.race()

        // then
        val movedPositions = cars.getAll().map { it.position }
        assertTrue(movedPositions.all { it == 1 })
    }

    @Test
    fun `모든 자동차가 이동하지 않는다`() {
        val names = listOf("pobi", "woni", "jun")
        val cars = Cars(names, FixedNumberGenerator(3))

        cars.race()

        val movedPositions = cars.getAll().map { it.position }
        assertTrue(movedPositions.all { it == 0 })
    }

    @Test
    fun `최대 위치에 있는 자동차가 우승자이다`() {
        val cars = Cars(listOf("a", "b", "c"), FixedNumberGenerator(5))
        cars.race()

        cars.getAll()[0].moveOrStop()

        val winners = cars.getWinner().names()
        assertThat(winners).isEqualTo("a")
    }

    @Test
    fun `자동차 이름에 중복이 있으면 예외를 던진다`() {
        assertThrows<IllegalArgumentException> {
            Cars(listOf("a", "b", "a"), RandomNumberGenerator)
        }
    }
}