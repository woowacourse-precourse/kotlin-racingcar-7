package racingcar.view

import racingcar.model.Car

object OutputView {
    fun printResult() {
        println("\n실행 결과")
    }

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car -> println("${car.name} : ${"-".repeat(car.position)}") }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }

    fun printErrorMessage(message: String) {
        println("오류 : $message")
    }
}
