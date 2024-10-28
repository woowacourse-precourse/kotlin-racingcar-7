package racingcar.view

import racingcar.model.Car

class OutputView {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach { println(it) }
        println()
    }

    fun gameResult() {
        println(GAME_RESULT_MESSAGE)
    }

    companion object {
        const val GAME_RESULT_MESSAGE = "실행 결과"
    }
}