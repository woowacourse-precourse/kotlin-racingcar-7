package racingcar

import camp.nextstep.edu.missionutils.Console

class Input {

    fun inputCars(): List<String> {
        return Console.readLine().split(",")
    }
}