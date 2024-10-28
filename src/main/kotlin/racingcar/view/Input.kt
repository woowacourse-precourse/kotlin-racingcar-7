package racingcar.view

import camp.nextstep.edu.missionutils.Console

class Input {
    fun raceCount(): String = readLine()
    fun carNames(): String = readLine()
    private fun readLine(): String = Console.readLine()
}