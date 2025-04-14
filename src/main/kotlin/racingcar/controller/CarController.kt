package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.numberGenerator.RandomNumberGenerator
import racingcar.view.View

class CarController(private val view: View) {
    fun run() {
        val cars = inputCars()
        val count = view.readRaceCount()

        view.printResultHeader()
        repeat(count) {
            cars.race()
            view.printRacing(cars)
            view.printNewLine()
        }

        printWinner(cars.getWinner())
    }

    private fun inputCars(): Cars {
        val carNames = view.readCarNames()
        return Cars(carNames, RandomNumberGenerator)
    }

    private fun printWinner(winners: List<Car>) {
        view.printWinners(winners)
    }
}
