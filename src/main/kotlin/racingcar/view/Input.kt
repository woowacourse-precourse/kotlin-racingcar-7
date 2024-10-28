package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validation.InputValidation

class Input {
    private val inputValidation = InputValidation()

    fun getCarNames(): List<String> = readLine()
        .split(",")
        .map {
            inputValidation.carName(it)
            it.trim()
        }

    fun getRaceRound(): Int = readLine().also { inputValidation.raceRound(it) }.toInt()

    private fun readLine(): String = Console.readLine()
}