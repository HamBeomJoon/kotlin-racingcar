package racingcar.controller

import racingcar.model.Cars
import racingcar.model.numberGenerator.RandomNumberGenerator
import racingcar.view.View

class CarController(private val view: View) {
    fun run() {
        val cars = inputCars()
        val count = view.readRaceCount()

        view.printResultHeader()
        racing(count, cars)

        printWinner(cars)
    }

    private fun racing(count: Int, cars: Cars) {
        repeat(count) {
            cars.race()
            view.printRacing(cars)
            view.printNewLine()
        }
    }

    private fun inputCars(): Cars {
        val carNames = view.readCarNames()
        return Cars(carNames, RandomNumberGenerator)
    }

    private fun printWinner(cars: Cars) {
        val winners = cars.getWinners()
        view.printWinners(winners.names())
    }
}
