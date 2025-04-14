package racingcar.model

import racingcar.model.numberGenerator.NumberGenerator

class RacingCars private constructor(
    val cars: List<Car>,
) {
    fun race() {
        for (car in cars) {
            car.moveOrStop()
        }
    }

    fun getWinners(): Winners {
        val maxPosition = cars.maxOf { car -> car.position }
        return Winners(cars.filter { car -> car.position == maxPosition })
    }

    companion object {
        fun from(carNames: List<String>, strategy: NumberGenerator): RacingCars {
            require(carNames.distinct().size == carNames.size) { "자동차 이름에 중복이 있습니다." }

            val cars = carNames.map { name -> Car(name, strategy) }
            return RacingCars(cars)
        }
    }
}
