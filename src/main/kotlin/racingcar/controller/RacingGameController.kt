package racingcar.controller

import racingcar.model.Game
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGameController(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
    private val racingGame: Game = Game(inputView.inputCarNames())
) {
    fun startGame() {
        val rounds = inputView.inputRounds()

        repeat(rounds) {
            racingGame.playRound()
            resultView.printRoundResult(racingGame.getCars())
        }

        val winners = racingGame.getWinners()
        resultView.printWinners(winners)
    }
}