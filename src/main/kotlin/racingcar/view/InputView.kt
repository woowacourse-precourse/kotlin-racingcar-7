package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val DELIMITER = ","

    fun getCars(): List<String> {
        return getUserInput().split(DELIMITER)
    }

    fun getAttempt(): String {
        return getUserInput()
    }

    private fun getUserInput(): String = Console.readLine()
}
