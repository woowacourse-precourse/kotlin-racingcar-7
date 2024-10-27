package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.util.Constant.MOVE_VALID_CONDITION
import racingcar.util.Constant.RANDOM_NUMBER_MAX_RANGE
import racingcar.util.Constant.ZERO
import racingcar.util.PrintMessage.RESULT_TITLE
import racingcar.util.PrintMessage.START_OUTPUT_MESSAGE
import racingcar.util.PrintMessage.TRY_NUMBER_OUTPUT_MESSAGE
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        outputView.printMessage(START_OUTPUT_MESSAGE)
        val inputCarList: List<String> = inputView.getInputCarName()
        val carList: List<RacingCar> = createRacingCarList(inputCarList)

        outputView.printMessage(TRY_NUMBER_OUTPUT_MESSAGE)
        val tryNumber: Int = inputView.getInputTryNumber()

        doRacing(carList, tryNumber)
    }

    private fun createRacingCarList(inputCarList: List<String>): List<RacingCar> {
        val carList = inputCarList.map { carItemName ->
            RacingCar(carName = carItemName)
        }

        return carList
    }

    private fun doRacing(carList: List<RacingCar>, tryNumber: Int) {
        outputView.printMessage(RESULT_TITLE)

        repeat(tryNumber) {
            val updatedCarList: List<RacingCar> = updateRacingCarList(carList)

            outputView.printRacingResult(updatedCarList)
        }
    }

    private fun updateRacingCarList(carList: List<RacingCar>): List<RacingCar> {
        carList.forEach { carItem ->
            moveRacingCarItem(carItem)
        }

        return carList
    }

    private fun moveRacingCarItem(carItem: RacingCar) {
        val randomMoveNumber = Randoms.pickNumberInRange(ZERO, RANDOM_NUMBER_MAX_RANGE)

        if (randomMoveNumber >= MOVE_VALID_CONDITION)
            carItem.onMoveCar()
    }
}
