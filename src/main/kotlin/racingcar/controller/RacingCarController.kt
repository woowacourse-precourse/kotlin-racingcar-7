package racingcar.controller

import racingcar.model.RacingCar
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
            carList.forEach { carItem ->
                carItem.onMoveCar()
            }

            outputView.printRacingResult(carList)
        }
    }
}
