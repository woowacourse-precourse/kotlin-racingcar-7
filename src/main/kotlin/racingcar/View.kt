package racingcar

import camp.nextstep.edu.missionutils.Console

class View {
    private val presenter = Presenter(this)

    fun start() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val names = Console.readLine()
        println("시도할 횟수는 몇 번인가요?")
        val iterationCount = Console.readLine()
        callPresenter(names, iterationCount)
    }

    private fun callPresenter(names: String, iterationCount: String) {
        presenter.execute(names, iterationCount)
    }

    fun printResult(roundResults: MutableList<MutableMap<String, Int>>) {
        roundResults.forEach { map ->
            printRoundResult(map)
        }
    }

    private fun printRoundResult(result: MutableMap<String, Int>) {
        result.forEach { (key, value) ->
            println("$key : ${distanceToString(value)}")
        }
    }

    private fun distanceToString(distance: Int): String {
        var stringResult = ""
        for (i in 1..distance) {
            stringResult += "-"
        }
        return stringResult
    }

    fun printWinners(winners: MutableList<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}