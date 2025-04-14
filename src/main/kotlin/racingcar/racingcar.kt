package racingcar

import racingcar.controller.CarController
import racingcar.view.View

fun main() {
    val view = View()
    val controller = CarController(view)
    controller.run()
}
