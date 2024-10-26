package racingcar.model

import racingcar.view.OutputView

class RacingGame(
    private val cars: List<Car>,
    private val attemptCount: AttemptCount
) {

    fun startRacing(outputView: OutputView) {
        outputView.printRaceResult()
        repeat(attemptCount.getNumber()) {
            playRound(cars)
            displayRoundResult(cars, outputView)
        }
        displayWinners(outputView)
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

    private fun findWinners(): String {
        val maxDistance = cars.maxOf { it.currentDistance }
        return cars
            .filter { it.currentDistance == maxDistance }
            .joinToString(WINNER_SEPARATOR) { it.getName() }
    }

    private fun displayWinners(outputView: OutputView) {
        val winnerNames = findWinners()
        outputView.printWinners(winnerNames)
    }

    companion object {
        private const val WINNER_SEPARATOR = ", "
    }
}