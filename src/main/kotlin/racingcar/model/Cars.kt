package racingcar.model

import racingcar.model.numberGenerator.RandomNumberGenerator

class Cars(carNames: List<String>) {
    val cars = carNames.map { name -> Car(name, RandomNumberGenerator) }

    init {
        require(carNames.distinct().size == carNames.size) { "자동차 이름에 중복이 있습니다." }
    }
}