package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCarGameController {

    fun play() {
        getCarNamesAndTryCounts()
    }

    private fun getCarNamesAndTryCounts() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val userInput = Console.readLine()
        val carNames = userInput.split(",")
        checkIfValidNames(carNames)
        getTryCountsInput()
    }

    private fun checkIfValidNames(carNames: List<String>) {
        if (carNames.all{it.length <= 5})
            return
        throw IllegalArgumentException()
    }

    private fun getTryCountsInput() {
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = Console.readLine()
        checkIfValidCount(tryCount)
    }

    private fun checkIfValidCount(tryCount: String) {
        if (tryCount.all{it.isDigit()}) {
            return
        }
        throw IllegalArgumentException()
    }
}