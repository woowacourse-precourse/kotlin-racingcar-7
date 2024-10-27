package racingcar.userInput

import camp.nextstep.edu.missionutils.Console

class CountInput {

    fun countInput(): String {
        val countInput = Console.readLine()
        println()
        return countInput
    }
}