package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.Constants
import racingcar.utils.Validation

class Input {
    fun getCars(): List<String> {
        println(Constants().INSERT_CAR_NAMES)
        val carName = Console.readLine().split(Constants().COMMA)
        Validation().checkCarName(carName)
        return carName
    }

    fun getCount(): Int {
        println(Constants().INSERT_COUNT)
        val count = Console.readLine()
        Validation().checkCount(count)
        return count.toInt()
    }

}