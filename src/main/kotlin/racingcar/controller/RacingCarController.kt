package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.view.InputView

class RacingCarController {
    private val inputView: InputView = InputView()

    fun start() {
        val carNames: List<String> = inputView.inputCarNames()
        val gameRound: Int = inputView.inputGameRound()
        val racingGame = RacingGame(carNames, gameRound)
        racingGame.play()
    }
}