package racingcar.controller

import racingcar.model.RacingCars
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

    private fun racing(count: Int, racingCars: RacingCars) {
        repeat(count) {
            racingCars.race()
            view.printRacing(racingCars)
            view.printNewLine()
        }
    }

    private fun inputCars(): RacingCars {
        val carNames = view.readCarNames()
        return RacingCars.from(carNames, RandomNumberGenerator)
    }

    private fun printWinner(racingCars: RacingCars) {
        val winners = racingCars.getWinners()
        view.printWinners(winners.names())
    }
}
