package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.feature.InputNames
import racingcar.feature.RacingCarGame
import racingcar.utils.isCountInvalid

fun main() {
    val inputNames = InputNames()
    inputNames.run {
        printInputNamesMessage()
        readNames()
        validateNames()
    }

    println("시도할 횟수는 몇 회인가요?")
    val countInput = Console.readLine()
    if (countInput.isCountInvalid()) throw IllegalArgumentException()

    println()

    val racingCarGame = RacingCarGame(inputNames.names)

    println("실행 결과")
    repeat(countInput.toInt()) {
        racingCarGame.moveCars()
        racingCarGame.printResults()
        println()
    }

    racingCarGame.printWinners()
}
