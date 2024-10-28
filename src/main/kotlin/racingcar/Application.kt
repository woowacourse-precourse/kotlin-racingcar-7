package racingcar

import racingcar.feature.InputCount
import racingcar.feature.InputNames
import racingcar.feature.RacingCarGame

fun main() {
    val inputNames = InputNames()
    inputNames.run {
        printInputNamesMessage()
        readNames()
        validateNames()
    }

    val inputCount = InputCount()
    inputCount.run {
        printInputCountMessage()
        readCount()
        validateCount()
    }

    println()

    println("실행 결과")
    val racingCarGame = RacingCarGame(inputNames.names)
    repeat(inputCount.count.toInt()) {
        racingCarGame.moveCars()
        racingCarGame.printResults()
        println()
    }

    racingCarGame.printWinners()
}
