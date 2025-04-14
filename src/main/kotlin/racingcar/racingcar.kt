package racingcar

fun main() {
    val view = View()
    val controller = CarController(view)
    controller.run()
}