package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Constant.CAR_NAME_SPLITTER
import racingcar.util.ErrorChecker

class InputView {
    private val errorChecker = ErrorChecker

    fun getInputCarName(): List<String> {
        val inputCar = Console.readLine()
        val carList = inputCar.split(CAR_NAME_SPLITTER)
        errorChecker.checkValidCardName(carList)

        return carList
    }

    fun getInputTryNumber(): Int {
        val tryNumber = Console.readLine()
        errorChecker.checkValidTryNumber(tryNumber)

        return tryNumber.toInt()
    }
}