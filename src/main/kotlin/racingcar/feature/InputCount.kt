package racingcar.feature

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.isCountInvalid

class InputCount {

    var count: String = ""

    fun printInputCountMessage() {
        println(INPUT_COUNT_MESSAGE)
    }

    fun readCount() {
        count = Console.readLine()
    }

    fun validateCount() {
        if (count.isCountInvalid()) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private const val INPUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}