package racingcar

import racingcar.controller.CarController
import racingcar.service.CarService
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val controller = CarController(InputView(), OutputView())
    controller.run()
}
