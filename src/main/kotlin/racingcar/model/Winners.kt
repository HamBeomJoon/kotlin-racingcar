package racingcar.model

class Winners(private val cars: List<Car>) {
    fun names(): String = cars.joinToString(", ") { car -> car.name }
}
