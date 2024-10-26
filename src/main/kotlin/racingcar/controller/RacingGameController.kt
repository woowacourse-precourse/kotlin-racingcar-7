package racingcar.controller

import racingcar.service.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController {
    private val racingGame = RacingGame()

    fun run() {
        val input = InputView.inputNames()
        val round = InputView.inputRound()

        OutputView.printProcess()
        val result = racingGame.start(input, round)
        OutputView.printResult(result)
    }
}
