package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.RacingCars
import racingcar.model.numberGenerator.FixedNumberGenerator
import racingcar.model.numberGenerator.RandomNumberGenerator

class RacingCarsTest {
    @Test
    fun `모든 자동차가 한 번씩 이동한다`() {
        // given
        val names = listOf("pobi", "woni", "jun")
        val racingCars = RacingCars.from(names, FixedNumberGenerator(5))

        // when
        racingCars.race()

        // then
        val movedPositions = racingCars.cars.map { it.position }
        assertTrue(movedPositions.all { it == 1 })
    }

    @Test
    fun `모든 자동차가 이동하지 않는다`() {
        val names = listOf("pobi", "woni", "jun")
        val racingCars = RacingCars.from(names, FixedNumberGenerator(3))

        racingCars.race()

        val movedPositions = racingCars.cars.map { it.position }
        assertTrue(movedPositions.all { it == 0 })
    }

    @Test
    fun `최대 위치에 있는 자동차가 우승자이다`() {
        val racingCars = RacingCars.from(listOf("a", "b", "c"), FixedNumberGenerator(5))
        racingCars.race()

        racingCars.cars[0].moveOrStop()

        val winners = racingCars.getWinners().names()
        assertThat(winners).isEqualTo("a")
    }

    @Test
    fun `자동차 이름에 중복이 있으면 예외를 던진다`() {
        assertThrows<IllegalArgumentException> {
            RacingCars.from(listOf("a", "b", "a"), RandomNumberGenerator)
        }
    }
}