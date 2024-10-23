package racingcar

import racingcar.resources.Messages as MSG

class OutputView {
    fun printGameStart() {
        println(MSG.GAME_START)
    }

    fun printInputCount() {
        println(MSG.GAME_INPUT_COUNT)
    }

    fun printRaceResult(firstLineBlank: Boolean) {
        if (firstLineBlank) {
            println()
        }
        println(MSG.GAME_RESULT)
    }

    fun printWinners(winners: List<String>) {
        println(MSG.GAME_WINNER.format(winners.joinToString(", ")))
    }

    fun printCarNameWithIndicator(car: Car, lastLineBlank: Boolean) {
        println("${car.name} : ${"-".repeat(car.distance)}")
        if (lastLineBlank) {
            println()
        }
    }
}