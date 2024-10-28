package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.constant.PrintMessage

class InputView {
    fun inputRacingCarName(): String {
        printInputRacingCarNameRequest()
        return Console.readLine()
    }

    fun inputAttemptCount(): String  {
        printInputAttemptCountRequest()
        return Console.readLine()
    }

    private fun printInputRacingCarNameRequest() {
        println(PrintMessage.INPUT_RACING_CAR_NAME_REQUEST)
    }

    private fun printInputAttemptCountRequest() {
        println(PrintMessage.INPUT_ATTEMPT_COUNT_REQUEST)
    }

}