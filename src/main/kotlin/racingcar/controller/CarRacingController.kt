package racingcar.controller

import racingcar.utils.Validator
import racingcar.view.InputView

object CarRacingController {
    fun run() {
        val inputNames = InputView.inputNames()
        Validator.validateInputNames(inputNames)
    }

}