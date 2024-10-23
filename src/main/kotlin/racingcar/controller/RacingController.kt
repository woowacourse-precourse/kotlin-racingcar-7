package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import racingcar.model.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController {
    private val inputView = InputView()
    private val outPutView = OutputView()

    fun run() {
        val cars = createCars()
        val moveCount = inputView.readMoveCount()

        println("실행 결과")
        repeat(moveCount) {
            racingCars(cars)
            println()
        }

    }

    private fun createCars() : List<Car> {
        val carNames = inputView.readCarNames()
        return carNames.map {name -> Car(name)}
    }

    private fun racingCars(cars : List<Car>) {
        cars.forEach { car ->
            if(pickNumberInRange(0, 9) >= 4) car.move()
            outPutView.printCarMove(car.name, car.movedDistance)
        }
    }

}