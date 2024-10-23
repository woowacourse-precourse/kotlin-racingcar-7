package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import racingcar.utils.Messages
import racingcar.model.Car
import racingcar.utils.Validator
import racingcar.utils.Values
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController {
    private val inputView = InputView()
    private val outPutView = OutputView()

    fun run() {
        val cars = createCars()
        cars.forEach { car -> Validator.isValidCarName(car.name) }

        val input = inputView.readMoveCount()
        Validator.isValidMoveCount(input)
        val moveCount = input.toInt()

        println(Messages.OUPUT_RESULT)
        repeat(moveCount) {
            raceCars(cars)
            println()
        }

        val winners = getWinners(cars)
        outPutView.printWinners(winners)

    }

    private fun createCars(): List<Car> {
        val carNames = inputView.readCarNames()
        return carNames.map { name -> Car(name) }
    }

    private fun raceCars(cars: List<Car>) {
        cars.forEach { car ->
            if (pickNumberInRange(
                    Values.MIN_RANDOM_NUMBER,
                    Values.MAX_RANDOM_NUMBER
                ) >= Values.MIN_MOVABLE_NUMBER
            ) car.move()
            outPutView.printCarMove(car.name, car.movedDistance)
        }
    }

    // 우승자는 한 명 이상이다
    private fun getWinners(cars: List<Car>): List<String> {
        val maxMove = cars.maxOf { it.movedDistance }
        return cars.filter { it.movedDistance == maxMove }.map { it.name }
    }

}