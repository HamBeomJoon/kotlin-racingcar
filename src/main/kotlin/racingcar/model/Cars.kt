package racingcar.model

class Cars(val carNames: List<String>) {
    val cars = carNames.map { name -> Car(name) }

    init {
        require(carNames.distinct().size == carNames.size) { "자동차 이름에 중복이 있습니다." }
    }
}