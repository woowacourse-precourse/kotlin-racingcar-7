package racingcar.controller

import camp.nextstep.edu.missionutils.Console

class RacingController {
    private var carState = mutableMapOf<String, Int>()

    fun start() {
        printInputCarName()
        val input = Console.readLine().split(",")
        for (carName in input) {
            carState[carName] = 0
        }

        printInputRaceCount()
        val raceCount = Console.readLine().toInt()

    }

    private fun printInputCarName() = println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    private fun printInputRaceCount() = println("시도할 횟수는 몇 회인가요?")

}