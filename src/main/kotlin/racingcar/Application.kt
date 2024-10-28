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

    val racingCarGame = RacingCarGame(
        names = inputNames.names,
        count = inputCount.count.toInt()
    )
    racingCarGame.startRace()
}
