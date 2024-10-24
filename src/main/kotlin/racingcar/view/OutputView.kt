package racingcar.view

import racingcar.constant.PrintMessage

class OutputView {
    fun printInputRacingCarNameRequest() {
        println(PrintMessage.INPUT_RACING_CAR_NAME_REQUEST)
    }

    fun printInputAttemptCountRequest() {
        println(PrintMessage.INPUT_ATTEMPT_COUNT_REQUEST)
    }

    fun printRaceResult() {
        println(PrintMessage.RACE_RESULT)
    }

    fun printFinalWinner(finalWinner: List<String>) {
        println(PrintMessage.FINAL_WINNER + finalWinner.joinToString(", "))
    }
}