package racingcar.view

import racingcar.model.Car
import racingcar.model.Cars

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

    fun printRacing(cars: Cars) {
        for (car in cars.getAll()) {
            println("${car.name} : " + "-".repeat(car.position))
        }
    }

    fun printWinners(winners: List<Car>) {
        val names = winners.joinToString(", ") { car -> car.name }
        println("최종 우승자: $names")
    }

    fun printNewLine() = println()
}