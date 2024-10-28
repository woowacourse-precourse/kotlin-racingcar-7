package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val outputView = OutputView()

    fun getNameOfCars(): String? {
        outputView.enterNameOfCars()
        return Console.readLine()
    }

    fun getTryCounts(): Int {
        outputView.enterTryCounts()
        return Console.readLine().toInt()
    }
}