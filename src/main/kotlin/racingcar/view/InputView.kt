package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.constant.ViewConstants

class InputView {
    fun getCarNameInput(): String {
        println(ViewConstants.CAR_NAME_INPUT_MESSAGE)
        return Console.readLine().trim()
    }

    fun getTryCountInput(): String {
        println(ViewConstants.TRY_COUNT_INPUT_MESSAGE)
        return Console.readLine().trim()
    }
}