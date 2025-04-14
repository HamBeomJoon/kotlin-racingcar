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

    private fun inputCars(): RacingCars {
        while (true) {
            val carNames = view.readCarNames()

            val result = runCatching {
                RacingCars.from(carNames, RandomNumberGenerator)
            }

            result.onSuccess { return it }
                .onFailure { error ->
                    view.printError(error.message ?: "알 수 없는 에러입니다.")
                }
        }
    }

    private fun racing(count: Int, racingCars: RacingCars) {
        repeat(count) {
            racingCars.race()
            view.printRacing(racingCars)
            view.printNewLine()
        }
    }

    private fun printWinner(racingCars: RacingCars) {
        val winners = racingCars.getWinners()
        view.printWinners(winners.names())
    }
}
