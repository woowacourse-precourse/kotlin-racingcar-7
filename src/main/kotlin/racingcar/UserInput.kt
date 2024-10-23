package racingcar

import camp.nextstep.edu.missionutils.Console

class UserInput {
    fun getCarsName() = Console.readLine()

    fun getRaceCount(): Int {
        val count = Console.readLine().toIntOrNull()
        requireNotNull(count) { println("숫자를 입력해주세요") }
        return count
    }
}