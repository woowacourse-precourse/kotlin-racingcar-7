package racingcar.infrastructure

import camp.nextstep.edu.missionutils.Console

interface Input {
    fun getInput(): String {
        val input = Console.readLine()

        return input
    }
}