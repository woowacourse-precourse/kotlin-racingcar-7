package racingcar.view

import racingcar.model.Car

class OutputView {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach { println(it) }
        println()
    }

    fun gameResult() {
        println()
        println(GAME_RESULT_MESSAGE)
    }

    fun printWinners(winners: List<String>) {
        val message = String.format(GAME_WINNERS_MESSAGE, winners.joinToString(","))
        println(message)
    }

    companion object {
        const val GAME_RESULT_MESSAGE = "실행 결과"
        const val GAME_WINNERS_MESSAGE = "최종 우승자 : %s"
    }
}