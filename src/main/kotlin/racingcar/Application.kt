package racingcar

import racingcar.model.Car
import racingcar.model.CarMove
import racingcar.model.RandomGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val carNames = inputView.getCarNames()
    val roundCount = inputView.getRoundCount()

    val cars = carNames.map { Car(it, CarMove(RandomGenerator())) }

    repeat(roundCount) {
        cars.forEach { it.move() }
        outputView.printRoundResult(cars)
    }
}
