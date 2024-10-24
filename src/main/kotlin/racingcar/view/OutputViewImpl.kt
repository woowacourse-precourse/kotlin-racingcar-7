package racingcar.view

import racingcar.model.Car

class OutputViewImpl : OutputView {

    override fun printNewLine() = println()

    override fun printRaceResult() = println(MESSAGE_RACE_RESULT)

    override fun printCarRoundInfo(car: Car) {
        println(MESSAGE_ROUND_INFO.format(car.getName(), car.currentDistance))
    }

    override fun printWinners(names: String) {
        println(MESSAGE_WINNERS.format(names))
    }

    companion object {
        private const val MESSAGE_RACE_RESULT = "실행 결과"
        private const val MESSAGE_ROUND_INFO = "%s : %s"
        private const val MESSAGE_WINNERS = "최종 우승자 : %s"
    }
}