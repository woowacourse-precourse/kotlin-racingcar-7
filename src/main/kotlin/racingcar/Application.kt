package racingcar

import racingcar.controller.CarController
import racingcar.view.InputView

fun main() {
    val view = InputView()
    val model = Model()
    val controller = CarController(model, view)
    controller.run()
}
