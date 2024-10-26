package racingcar.controller

import racingcar.utils.Validator
import racingcar.view.InputView

object RacingCarController {
    fun run() {
        val inputNames = InputView.inputNames()
        Validator.validateInputNames(inputNames)

    }

}