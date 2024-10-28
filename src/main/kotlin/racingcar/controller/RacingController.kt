package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarMove
import racingcar.model.RandomGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val carNames = inputView.getCarNames()
        val roundCount = inputView.getRoundCount()

        val cars = carNames.map { Car(it, CarMove(RandomGenerator())) }

        outputView.gameResult()

        repeat(roundCount) {
            cars.forEach { it.move() }
            outputView.printRoundResult(cars)
        }
    }
}