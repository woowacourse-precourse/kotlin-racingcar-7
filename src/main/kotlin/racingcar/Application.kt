package racingcar

import racingcar.controller.CarController

fun main() {
    val view = View()
    val model = Model()
    val controller = CarController(model, view)
    controller.run()
}
