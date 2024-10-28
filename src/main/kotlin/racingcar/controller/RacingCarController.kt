package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.view.InputView

class RacingCarController {
    fun start() {
        val carNames: List<String> = InputView.inputCarNames()
        val gameRound: Int = InputView.inputGameRound()
        val racingGame = RacingGame(carNames, gameRound)
        racingGame.play()
    }
}