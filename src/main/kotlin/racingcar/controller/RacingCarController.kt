package racingcar.controller

import racingcar.model.Model
import racingcar.utils.Validator
import racingcar.view.InputView

object RacingCarController {
    fun run() {
        val inputNames = InputView.inputNames()
        Validator.validateInputNames(inputNames)
        val round = InputView.inputRound().toInt()
        Validator.validateInputRound(round.toString())

        inputNames.split(",").map { it.trim() }.map { Model(it) }
    }

}