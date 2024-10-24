package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

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

        printOutputRaceResult()
        repeat(raceCount) {
            race(carState)
            println()
        }

    }

    private fun printInputCarName() = println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    private fun printInputRaceCount() = println("시도할 횟수는 몇 회인가요?")

    private fun printOutputRaceResult() = println("\n실행 결과")

    private fun race(carState: MutableMap<String, Int>) {
        for (car in carState.keys) {
            if (checkForward()) {
                // !!써서 carState[car]!! + 1  or  carState[car]!!.plus(1) 쓸지 얘로 쓸지 고민..
                carState[car] = carState.getValue(car) + 1
            }

            println("$car : " + "-".repeat(carState.getValue(car)))
        }
    }

    private fun checkForward(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}