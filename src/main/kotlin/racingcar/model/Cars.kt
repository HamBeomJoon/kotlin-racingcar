package racingcar.model

import racingcar.model.numberGenerator.NumberGenerator

class Cars private constructor(
    private val cars: List<Car>,
) {
    fun getAll(): List<Car> = cars.toList()

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
        fun from(carNames: List<String>, strategy: NumberGenerator): Cars {
            require(carNames.distinct().size == carNames.size) { "자동차 이름에 중복이 있습니다." }

            val cars = carNames.map { name -> Car(name, strategy) }
            return Cars(cars)
        }
    }
}
