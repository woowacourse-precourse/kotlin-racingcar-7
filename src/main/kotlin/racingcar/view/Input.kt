package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.Constants

class Input {
    fun getCars():List<String>{
        println(Constants().INSERT_CAR_NAMES)
        return Console.readLine().split(Constants().COMMA)
    }

    fun getCount():Int{
        println(Constants().INSERT_COUNT)
        return Console.readLine().toInt()
    }

}