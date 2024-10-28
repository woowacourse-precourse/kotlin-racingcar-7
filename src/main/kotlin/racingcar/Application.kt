package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.isCountInvalid
import racingcar.utils.isNamesInvalid

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val namesInput = Console.readLine()
    if (namesInput.isNamesInvalid()) throw IllegalArgumentException()

    println("시도할 횟수는 몇 회인가요?")
    val countInput = Console.readLine()
    if (countInput.isCountInvalid()) throw IllegalArgumentException()

    println()

    val names = namesInput.split(',')
    val count = countInput.toInt()
    val racingCarGame = RacingCarGame(names)

    println("실행 결과")
    repeat(count) {
        racingCarGame.moveCars()
        racingCarGame.printResults()
        println()
    }

    racingCarGame.printWinners()
}
