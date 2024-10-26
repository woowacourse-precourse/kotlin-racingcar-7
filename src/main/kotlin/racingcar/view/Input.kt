package racingcar.view

import racingcar.utils.Constants

class Input {
    fun getCars():List<String>{
        println(Constants().INSERT_CAR_NAMES)
        return camp.nextstep.edu.missionutils.Console.readLine().split(",")
    }
}