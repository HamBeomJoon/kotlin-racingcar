package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.view.View

class CarController(private val view: View) {
    fun run() {
        val cars = inputCars()
        val count = view.readRaceCount()

        view.printResultHeader()
        repeat(count) {
            race(cars)
        }

        printWinner(cars)
    }

    private fun inputCars(): List<Car> {
        val carNames = view.readCarNames()
        return Cars(carNames).cars
    }

    private fun race(cars: List<Car>) {
        for (car in cars) {
            car.moveOrStop()
            view.printRacing(car)
        }
        view.printNewLine()
    }

    private fun printWinner(cars: List<Car>) {
        val maxPosition = cars.maxOf { car -> car.position }
        val winners = cars.filter { car -> car.position == maxPosition }
        view.printWinners(winners)
    }
}