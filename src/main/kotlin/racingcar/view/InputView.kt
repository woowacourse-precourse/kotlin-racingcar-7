package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    val outputView = OutputView()

    fun getNameOfCars(): String? {
        outputView.enterNameOfCars()
        return Console.readLine()
    }
}