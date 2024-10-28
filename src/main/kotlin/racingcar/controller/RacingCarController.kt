package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.utils.DataFormatter
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val dataFormatter = DataFormatter()

    fun startRace() {
        val cars = dataFormatter.getCarList(inputView.readCarNames())
        val times = dataFormatter.getTimes(inputView.readTimes())

        outputView.printProcessLabel()
        repeat(times) {
            moveCars(cars)
            outputView.printProcess(cars)
        }

        outputView.printResult(dataFormatter.getWinner(cars))
    }

    private fun moveCars(cars: List<Car>) {
        cars.forEach { car ->
            if (canMove()) car.move.append("-")
        }
    }

    private fun canMove(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}