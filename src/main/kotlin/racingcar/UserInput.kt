package racingcar

import camp.nextstep.edu.missionutils.Console

class UserInput {
    fun getCarsName() = Console.readLine()

    fun getRaceCount(): Int {
        val count = Console.readLine().toIntOrNull()
        requireNotNull(count) { println(INPUT_INTEGER_ERROR_MESSAGE) }
        return count
    }

    companion object {
        private const val INPUT_INTEGER_ERROR_MESSAGE = "정수를 입력해주세요"
    }
}