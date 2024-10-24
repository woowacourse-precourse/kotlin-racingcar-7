package racingcar

import camp.nextstep.edu.missionutils.Console

class Race(private val cars: Cars) {
    fun start() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val nameString = Console.readLine()
        println("시도할 횟수는 몇 번인가요?")
        val iterString = Console.readLine()
        execute(nameString, iterString)
    }

    private fun execute(nameString: String, iterString: String) {
        val validated = cars.validation(nameString, iterString)
        var resultMap = mutableMapOf<String, Int>()
        println("실행 결과")
        for (i in 1..validated.second) {
            resultMap = cars.forward(validated.first)
            printResult(resultMap)
            println()
        }
        println("최종 우승자 : ${cars.findWinner(resultMap).joinToString(", ")}")
    }

    private fun printResult(resultMap: MutableMap<String, Int>) {
        resultMap.forEach { (key, value) ->
            println("$key : ${toStringResult(value)}")
        }
    }

    private fun toStringResult(distance: Int): String {
        var stringResult = ""
        for (i in 1..distance) {
            stringResult += "-"
        }
        return stringResult
    }
}