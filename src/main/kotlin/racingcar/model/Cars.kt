package racingcar.model

import racingcar.model.numberGenerator.NumberGenerator

class Cars(carNames: List<String>, private val strategy: NumberGenerator) {
    private val cars: List<Car> = carNames.map { name -> Car(name, strategy) }

    init {
        require(carNames.distinct().size == carNames.size) { "자동차 이름에 중복이 있습니다." }
    }

    fun getAll(): List<Car> = cars.toList()

    fun race() {
        for (car in cars) {
            car.moveOrStop()
        }
    }

    fun getWinner(): Winners {
        val maxPosition = cars.maxOf { car -> car.position }
        return Winners(cars.filter { car -> car.position == maxPosition })
    }
}
