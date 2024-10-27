package racingcar.controller

import racingcar.util.ErrorChecker
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val errorChecker = ErrorChecker

    fun start() {
        outputView.printStartMessage()
        val inputCarList: List<String> = inputView.getInputCarName()
        errorChecker.checkValidCardName(inputCarList)
    }
}