package racingcar.view

import camp.nextstep.edu.missionutils.Console.readLine as readLineAPI
import racingcar.resources.Messages

class RacingGameView {
    // Input Views
    fun readLine(): String {
        return readLineAPI()
    }

    // Output Views
    fun showBlankLine() {
        println()
    }

    fun showGameStart() {
        println(Messages.GAME_START)
    }

    fun showInputCount() {
        println(Messages.GAME_INPUT_COUNT)
    }

    fun showRaceResultHeader() {
        println(Messages.GAME_RESULT_HEADER)
    }

    fun showWinners(winners: List<String>) {
        println(Messages.GAME_WINNER.format(winners.joinToString(", ")))
    }

    fun showCarNameWithIndicator(name: String, distance: Int) {
        println("$name : ${"-".repeat(distance)}")
    }
}