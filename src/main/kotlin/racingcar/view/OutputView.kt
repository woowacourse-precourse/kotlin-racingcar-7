package racingcar.view

import racingcar.utils.Messages

class OutputView {

    fun printCarMove(carName: String, movedDistance: Int) {
        println("$carName : ${Messages.MOVING_SYMBOL.repeat(movedDistance)}")
    }

    fun printWinners(winners: List<String>) {
        println("${Messages.FINAL_WINNER} : ${winners.joinToString(", ")}")
    }
}