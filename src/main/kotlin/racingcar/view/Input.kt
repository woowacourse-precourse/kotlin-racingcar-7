package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.constant.Message.COMMA
import racingcar.constant.Message.INFO_GET_CAR_NAMES
import racingcar.constant.Message.INFO_GET_ROUND
import racingcar.validation.InputValidation

class Input {
    private val inputValidation = InputValidation()

    fun getCarNames(): List<String> {
        println(INFO_GET_CAR_NAMES)
        return readLine()
            .split(COMMA)
            .map {
                inputValidation.carName(it)
                it.trim()
            }
    }

    fun getRaceRound(): Int {
        println(INFO_GET_ROUND)
        return readLine().also { inputValidation.raceRound(it) }.toInt()
    }

    private fun readLine(): String = Console.readLine()
}