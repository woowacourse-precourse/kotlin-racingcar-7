package racingcar.view

import racingcar.model.Car

interface OutputView {

    fun printNewLine()

    fun printRaceResult()

    fun printCarRoundInfo(car: Car)

    fun printWinners(names: String)
}