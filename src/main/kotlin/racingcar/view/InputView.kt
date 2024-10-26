package racingcar.view

import camp.nextstep.edu.missionutils.Console.readLine

object InputView {
    fun getCarNames(): List<String> {
        val input = getInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return input.split(',')
    }

    fun getMoveCount(): Int {
        val input = getInput("시도할 횟수는 몇 회인가요?")
        return input.toInt()
    }

    private fun getInput(prompt: String): String {
        println(prompt)
        return readLine() ?: ""
    }
}
