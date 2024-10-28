package racingcar.controller

import racingcar.view.InputView

class RacingGameController(
    private val inputView: InputView = InputView()
) {
    fun startGame() {
        val rounds = inputView.inputRounds()
    }
}