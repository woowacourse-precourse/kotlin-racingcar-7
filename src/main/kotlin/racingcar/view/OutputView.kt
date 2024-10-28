package racingcar.view

import racingcar.constant.GameSettings
import racingcar.constant.PrintMessage

class OutputView {
    fun printRaceResult() {
        printBlank()
        println(PrintMessage.RACE_RESULT)
    }

    fun printFinalWinner(finalWinner: List<String>) {
        println(PrintMessage.FINAL_WINNER + finalWinner.joinToString(GameSettings.JOIN_TO_STRING_SEPARATOR))
    }

    fun printBlank() {
        println(PrintMessage.BLANK)
    }
}