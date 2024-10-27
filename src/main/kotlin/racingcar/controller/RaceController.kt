package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.utils.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    private val cars = mutableListOf<Car>()

    fun startRace() {
        val carNames = InputView.getCarNames()
        Validator.validateCarName(carNames)
        createCars(carNames)

        val moveCount = InputView.getMoveCount()
        Validator.validateMoveCount(moveCount)
        moveCars(moveCount)

        OutputView.displayCarPositions(cars)
        val winners = getWinners()
        OutputView.displayWinners(winners)
    }

    private fun createCars(carNames: List<String>) {
        cars.addAll(carNames.map { Car(it) })
    }

    private fun moveCars(moveCount: Int) {
        for (i in 0 until moveCount) {
            moveCarsForRound()
        }
    }

    private fun moveCarsForRound() {
        cars.forEach { car ->
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move()
            }
        }
    }

    private fun getWinners(): String {
        val maxPosition = cars.maxOf { it.position }
        val winnerList = cars.filter { it.position == maxPosition }
        return winnerList.joinToString(", ") { it.name }
    }
}
