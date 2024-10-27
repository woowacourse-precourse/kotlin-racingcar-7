package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.util.Constant.MOVE_VALID_CONDITION
import racingcar.util.Constant.RANDOM_NUMBER_MAX_RANGE
import racingcar.util.Constant.WINNER_JOIN_LETTER
import racingcar.util.Constant.ZERO
import racingcar.util.PrintMessage.RESULT_TITLE
import racingcar.util.PrintMessage.START_OUTPUT_MESSAGE
import racingcar.util.PrintMessage.TRY_NUMBER_OUTPUT_MESSAGE
import racingcar.util.PrintMessage.WINNER_RESULT_CONTENT
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

    fun createRacingCarList(inputCarList: List<String>): List<RacingCar> {
        val carList = inputCarList.map { carItemName ->
            RacingCar(carName = carItemName)
        }

        return carList
    }

    private fun doRacing(carList: List<RacingCar>, tryNumber: Int) {
        outputView.printMessage(RESULT_TITLE)

        var updatedCarList: List<RacingCar> = emptyList()
        repeat(tryNumber) {
            updatedCarList = updateRacingCarList(carList)

            outputView.printRacingResult(updatedCarList)
        }

        checkFinalWinner(updatedCarList)
    }

    private fun updateRacingCarList(carList: List<RacingCar>): List<RacingCar> {
        carList.forEach { carItem ->
            moveRacingCarItem(carItem)
        }

        return carList
    }

    private fun moveRacingCarItem(carItem: RacingCar) {
        val randomMoveNumber = Randoms.pickNumberInRange(ZERO, RANDOM_NUMBER_MAX_RANGE)

        if (isValidMoveCondition(randomMoveNumber))
            carItem.onMoveCar()
    }

    fun isValidMoveCondition(randomNumber: Int): Boolean = randomNumber >= MOVE_VALID_CONDITION

    fun checkFinalWinner(carList: List<RacingCar>) {
        val maxLocationCarNameList = checkMaxLocation(carList)
        val winner: String = maxLocationCarNameList.joinToString(WINNER_JOIN_LETTER)

        outputView.printMessage("$WINNER_RESULT_CONTENT : $winner")
    }

    private fun checkMaxLocation(carList: List<RacingCar>): List<String> {
        val maxLocation = carList.maxOf { carItem ->
            carItem.location
        }

        val maxLocationCarNameList: List<String> = carList.filter { carItem ->
            carItem.location == maxLocation
        }.map { maxCarItem ->
            maxCarItem.carName
        }

        return maxLocationCarNameList
    }
}
