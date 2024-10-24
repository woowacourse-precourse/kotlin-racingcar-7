package racingcar.view

import racingcar.model.Car
import camp.nextstep.edu.missionutils.Console.readLine as readLineAPI
import racingcar.resources.Messages

class RacingGameView {
    // Input Views
    fun readLine(): String {
        return readLineAPI()
    }

    // Output Views
    fun printGameStart() {
        println(Messages.GAME_START)
    }

    fun printInputCount() {
        println(Messages.GAME_INPUT_COUNT)
    }

    fun printRaceResult(firstLineBlank: Boolean) {
        if (firstLineBlank) {
            println()
        }
        println(Messages.GAME_RESULT)
    }

    fun printWinners(winners: List<String>) {
        println(Messages.GAME_WINNER.format(winners.joinToString(", ")))
    }

    fun printCarNameWithIndicator(car: Car, lastLineBlank: Boolean) {
        println("${car.name} : ${"-".repeat(car.distance)}")
        if (lastLineBlank) {
            println()
        }
    }
}