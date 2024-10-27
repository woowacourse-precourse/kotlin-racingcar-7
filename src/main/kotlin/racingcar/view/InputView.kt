package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Constant.CAR_NAME_SPLITTER

class InputView {

    fun getInputCarName(): List<String> {
        val inputCar = Console.readLine()
        val carList = inputCar.split(CAR_NAME_SPLITTER)

        return carList
    }
}