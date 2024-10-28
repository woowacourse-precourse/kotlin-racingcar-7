package racingcar.view

import racingcar.model.Car

object OutputView {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car -> println("${car.name} : ${"-".repeat(car.position)}") }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}
