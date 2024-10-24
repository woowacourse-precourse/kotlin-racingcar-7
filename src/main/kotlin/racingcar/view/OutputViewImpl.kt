package racingcar.view

import racingcar.model.Car

class OutputViewImpl : OutputView {

    override fun printNewLine() = println()

    override fun printRaceResult() = println("실행 결과")

    override fun printCarRoundInfo(car: Car) {
        println("${car.getName()} : ${car.currentDistance}")
    }

    override fun printWinners(names: String) {
        println("최종 우승자 : $names")
    }
}