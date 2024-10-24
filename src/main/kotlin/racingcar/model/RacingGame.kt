package racingcar.model

import racingcar.view.OutputView

class RacingGame(
    private val cars: List<Car>,
    private val attemptCount: AttemptCount
) {

    fun startRacing(outputView: OutputView) {
        repeat(attemptCount.getNumber()) {
            playRound(cars)
            displayRoundResult(cars, outputView)
        }
    }

    private fun playRound(cars: List<Car>) {
        for (car in cars) {
            if (car.canMove()) {
                car.moveForward()
            }
        }
    }

    private fun displayRoundResult(cars: List<Car>, outputView: OutputView) {
        for (car in cars) {
            outputView.printCarRoundInfo(car)
        }
        outputView.printNewLine()
    }
}