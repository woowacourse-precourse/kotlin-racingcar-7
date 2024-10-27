package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getInputCarName(): List<String> {
        val inputCar = Console.readLine()
        val carList = inputCar.split(CAR_NAME_SPLITTER)

        return carList
    }

    companion object {
        private const val CAR_NAME_SPLITTER = ','
    }
}