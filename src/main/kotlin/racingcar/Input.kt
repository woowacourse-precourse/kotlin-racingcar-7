package racingcar

import camp.nextstep.edu.missionutils.Console

class Input {
    fun carNames() = Console.readLine().split(",")
    fun moveCount() = Console.readLine().toInt()
}