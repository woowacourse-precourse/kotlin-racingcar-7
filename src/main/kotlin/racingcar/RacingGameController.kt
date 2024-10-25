package racingcar

import racingcar.model.RacingGame
import racingcar.util.CarValidator
import racingcar.util.TryCountValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController(
    inputView: InputView = InputView(),
    outputView: OutputView = OutputView()
) {

    private val racingGame: RacingGame = RacingGame()

    init {
        val carNames = inputView.getRacingCarNames()
        CarValidator.validateCarName(carNames)
        racingGame.generateCars(carNames)

        val tryCount = inputView.getRacingTryCount()
        TryCountValidator.validateTryCount(tryCount)

        outputView.printRacingStart()
        repeat(tryCount.toInt()) {
            racingGame.tryRacingGame()

            val racingGameProgress = racingGame.getCars().map { Pair(it.name, it.moveCount) }
            outputView.printRacingProgress(racingGameProgress)
        }

        val winners = racingGame.getWinners()
        outputView.printWinners(winners)
    }
}