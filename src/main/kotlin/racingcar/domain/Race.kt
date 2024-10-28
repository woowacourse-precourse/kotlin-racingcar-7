package racingcar.domain

import racingcar.data.Car
import racingcar.data.Cars
import racingcar.data.Cars.Companion.convertCarsToList
import racingcar.data.Round
import racingcar.data.Round.Companion.convertRoundCountToInt
import racingcar.ui.InputView
import racingcar.ui.OutputView
import racingcar.utils.Random
import racingcar.utils.Winner

class Race(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun start() {
        val cars = buildCars().convertCarsToList()
        val round = buildRound().convertRoundCountToInt()
        repeatRounds(cars, round)
        printWinner(cars)
    }

    private fun buildCars(): Cars {
        outputView.printCarsNameInput()
        return inputView.parseCars()
    }

    private fun buildRound(): Round {
        outputView.printRoundCountInput()
        return inputView.parseRound()
    }

    private fun repeatRounds(cars: List<Car>, round: Int) {
        outputView.printNewLine()
        outputView.printResultTitle()
        repeat(round) { showRoundResult(cars) }
    }

    private fun showRoundResult(cars: List<Car>) {
        for (car in cars) {
            outputView.printRoundResult(car.name, car.move(Random.pick()))
        }
        outputView.printNewLine()
    }

    private fun printWinner(cars: List<Car>) = outputView.printWinner(Winner.calculate(cars))
}