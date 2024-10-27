package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.Messages

class InputView {
    fun readCarNames(): List<String> {
        println(Messages.INPUT_CAR_NAME_PROMPT)
        return Console.readLine().split(',')
    }

    fun readMoveCount(): String {
        println(Messages.INPUT_MOVE_COUNT_PROMPT)
        return Console.readLine()
    }
}