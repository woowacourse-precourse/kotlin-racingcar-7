package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        outputView.printStartMessage()
        val inputCarList: List<String> = inputView.getInputCarName()

        outputView.printTryNumberMessage()
        val tryNumber: Int = inputView.getInputTryNumber()
    }
}