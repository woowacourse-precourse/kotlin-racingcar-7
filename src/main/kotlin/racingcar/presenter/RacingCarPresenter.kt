package racingcar.presenter

import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.view.OutputView

class RacingCarPresenter(private val outputView: OutputView) {

    fun startRacing(carNames: List<String>, attemptCount: Int) {
        val cars = carNames.map { Car(it) }
        val game = RacingGame(cars)

        outputView.printRaceResult()
        repeat(attemptCount) {
            game.playRound()
            displayRoundResult(cars)
        }

        val winners = game.findWinners()
        displayWinners(winners)
    }

    private fun displayRoundResult(cars: List<Car>) {
        for (car in cars) {
            outputView.printCarRoundInfo(car)
        }
        outputView.printNewLine()
    }

    private fun displayWinners(winnerNames: String) {
        outputView.printWinners(winnerNames)
    }
}