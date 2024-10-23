package racingcar

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputCarNames(): List<String> {
        return Console.readLine().split(",")
    }

    fun inputRaceCount(): String {
        return Console.readLine()
    }
}