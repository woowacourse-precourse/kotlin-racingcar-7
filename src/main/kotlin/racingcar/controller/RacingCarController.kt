package racingcar.controller

import racingcar.view.InputView

class RacingCarController {
    private val inputView: InputView = InputView()

    fun start() {
        val carNames: List<String> = inputView.inputCarNames()
        val gameRound: Int = inputView.inputGameRound()
    }
}