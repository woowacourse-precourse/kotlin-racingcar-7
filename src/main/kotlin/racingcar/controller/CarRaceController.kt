package racingcar.controller

import racingcar.model.CarName
import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.OutputView

class CarRaceController(
    private val carNameModel: CarName = CarName(),
    private val racingModel: Race = Race(),
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    fun run() {
        val carNameList = getValidatedCarNames()
        val tryCountInput = parseAndValidateTryCount()

        outputView.showResultMessage()

        var carWithCount = racingModel.changeNameListToNameWithCountList(carNameList)
        repeat(tryCountInput) {
            carWithCount = racingModel.updateCarLocation(carWithCount)
            displayRoundResult(carWithCount)
            outputView.roundSeparator()
        }

        val winners = racingModel.getWinners(carWithCount)
        outputView.showWinners(winners)
    }

    private fun getValidatedCarNames(): List<String> {
        val carNameInput = inputView.getCarNameInput()
        val carNameList = carNameModel.splitNameByComma(carNameInput)

        return carNameModel.changeDuplicateName(carNameList)
    }

    private fun parseAndValidateTryCount(): Int {
        val stringTypeTryCountInput = inputView.getTryCountInput()

        return racingModel.adjustTryCountInputType(stringTypeTryCountInput)
    }

    private fun displayRoundResult(carWithCount: List<Pair<String, Int>>) {
        for (car in carWithCount) {
            val result = racingModel.getRoundResult(car.second)
            outputView.showRoundResult(car.first, result)
        }
    }
}