package racingcar.view

import racingcar.model.Car

interface OutputView {

    fun printNewLine()

    fun printCarRoundInfo(car: Car)
}