package racingcar

import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController(
    inputView: InputView = InputView(),
    outputView: OutputView = OutputView()
) {

    private val racingGame: RacingGame = RacingGame()

    init {
        val carNames = inputView.getRacingCarNames()
        racingGame.generateCars(carNames)

        val tryCount = inputView.getRacingTryCount()

        outputView.printRacingStart()
        repeat(tryCount) {
            racingGame.tryRacingGame()

            val racingGameProgress = racingGame.getCars().map { Pair(it.name, it.moveCount) }
            outputView.printRacingProgress(racingGameProgress)
        }

        val winners = racingGame.getWinners()
        outputView.printWinners(winners)
    }
}