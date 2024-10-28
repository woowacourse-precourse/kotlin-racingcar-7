package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.InputMessages

object InputView {
    fun getCarNames(): List<String> {
        println(InputMessages.CAR_NAME_INPUT_MESSAGE)
        return Console.readLine().split(",")
    }

    fun getNumberOfRounds(): String {
        println(InputMessages.NUMBER_OF_ROUNDS_INPUT_MESSAGE)
        return Console.readLine()
    }
}
