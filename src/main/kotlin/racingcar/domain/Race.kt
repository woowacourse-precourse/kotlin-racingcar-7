package racingcar.domain

import racingcar.data.Car
import racingcar.data.Cars.Companion.toList
import racingcar.data.Round.Companion.toInt
import racingcar.ui.InputView
import racingcar.ui.OutputView
import racingcar.utils.Random
import racingcar.utils.Winner

class Race(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun start() {
        val cars = buildCars()
        val round = buildRound()
        repeatRounds(cars, round)
        printWinner(cars)
    }

    private fun buildCars(): List<Car> {
        outputView.printCarsNameInput()
        return inputView.parseCars().toList()
    }

    private fun buildRound(): Int {
        outputView.printRoundCountInput()
        return inputView.parseRound().toInt()
    }

    private fun repeatRounds(cars: List<Car>, round: Int) {
        outputView.printNewLine()
        outputView.printResultTitle()
        repeat(round) { startRound(cars) }
    }

    private fun startRound(cars: List<Car>) = showRoundResult(cars)

    private fun showRoundResult(cars: List<Car>) {
        for (car in cars) {
            outputView.printRoundResult(car.name, car.move(Random.pick()))
        }
        outputView.printNewLine()
    }

    private fun printWinner(cars: List<Car>) = outputView.printWinner(Winner.calculate(cars))
}