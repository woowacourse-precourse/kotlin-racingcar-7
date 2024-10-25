package racingcar.infrastructure

import camp.nextstep.edu.missionutils.Console

class ConsoleInput {

    fun getCarNames(): String {
        println(REQUEST_CARNAME_MESSAGE)

        val input = Console.readLine()
        Console.close()

        return input
    }

    fun getMatches(): String {
        println(REQUEST_MATCHES_MESSAGE)

        val input = Console.readLine()
        Console.close()

        return input
    }

    companion object {
        private const val REQUEST_CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val REQUEST_MATCHES_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}