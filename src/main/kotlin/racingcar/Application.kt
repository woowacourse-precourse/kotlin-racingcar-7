package racingcar

import camp.nextstep.edu.missionutils.*

fun main() {
    val check = CheckException()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = Console.readLine()
    check.firstInput(cars)

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = Console.readLine()
    check.secondInput(tryCount)

    val raceGame = RaceGame()
    raceGame.play(cars, tryCount.toFloat().toInt())
}
