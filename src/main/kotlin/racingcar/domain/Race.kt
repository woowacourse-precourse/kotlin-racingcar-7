package racingcar.domain

import racingcar.data.Car
import racingcar.data.Cars.Companion.toList
import racingcar.data.Round.Companion.toInt
import racingcar.ui.InputView
import racingcar.ui.OutputView

class Race(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun start() {
        val cars = buildCars()
        val round = buildRound()
    }

    private fun buildCars(): List<Car> {
        outputView.printCarsNameInput()
        return inputView.parseCars().toList()
    }

    private fun buildRound(): Int {
        outputView.printRoundCountInput()
        return inputView.parseRound().toInt()
    }
}