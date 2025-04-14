package racingcar.view

import racingcar.model.RacingCars

class View {
    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln().split(",").map { it.trim() }
    }

    fun readRaceCount(): Int {
        println("\n시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }

    fun printResultHeader() = println("\n실행 결과")

    fun printRacing(racingCars: RacingCars) {
        for (car in racingCars.cars) {
            println("${car.name} : " + "-".repeat(car.position))
        }
    }

    fun printWinners(winners: String) {
        println("최종 우승자: $winners")
    }

    fun printNewLine() = println()
}
