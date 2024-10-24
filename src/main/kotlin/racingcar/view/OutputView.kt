package racingcar.view

import racingcar.constant.PrintMessage

class OutputView {
    fun printRaceResult() {
        println(PrintMessage.RACE_RESULT)
    }

    fun printFinalWinner(finalWinner: List<String>) {
        println(PrintMessage.FINAL_WINNER + finalWinner.joinToString(", "))
    }
}