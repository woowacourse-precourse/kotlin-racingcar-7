package racingcar.controller

import racingcar.model.Car
import racingcar.view.InputView

class RacingController {
    private val inputView = InputView()

    fun run() {
        val cars = createCars()
        val moveCount = inputView.readMoveCount()

    }

    private fun createCars() : List<Car> {
        val carNames = inputView.readCarNames()
        return carNames.map {name -> Car(name)}
    }

}