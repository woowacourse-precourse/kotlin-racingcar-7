package racingcar

import racingcar.controller.RacingCarController
import racingcar.model.RacingCarModel
import racingcar.view.RacingCarView

fun main() {
    val model = RacingCarModel()
    val view = RacingCarView()
    val controller = RacingCarController(model, view)

    controller.run()

}
