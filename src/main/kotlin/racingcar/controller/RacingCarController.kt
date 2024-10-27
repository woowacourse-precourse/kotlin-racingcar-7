package racingcar.controller

import racingcar.view.OutputView

class RacingCarController {
    private val outputView = OutputView()

    fun start() {
        outputView.printStartMessage()
    }
}