package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import racingcar.model.Car
import racingcar.view.InputView
import java.nio.file.Files.move

class RacingController {
    private val inputView = InputView()

    fun run() {
        val cars = createCars()
        val moveCount = inputView.readMoveCount()

        repeat(moveCount) {
            racingCars(cars)
        }

    }

    private fun createCars() : List<Car> {
        val carNames = inputView.readCarNames()
        return carNames.map {name -> Car(name)}
    }

    private fun racingCars(cars : List<Car>) {
        cars.forEach { car ->
            if(pickNumberInRange(0, 9) >= 4) car.move()
        }
    }

}