package racingcar.infrastructure

import camp.nextstep.edu.missionutils.Console

class ConsoleInput {

    private fun getInput(): String {
        val input = Console.readLine()
        return input
    }

    fun closeInput() {
        Console.close()
    }

    fun getCarNames(): String{
        println(REQUEST_CARNAME_MESSAGE)
        return getInput()
    }

    fun getMatches(): String {
        println(REQUEST_MATCHES_MESSAGE)
        return getInput()
    }

    companion object {
        private const val REQUEST_CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val REQUEST_MATCHES_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}