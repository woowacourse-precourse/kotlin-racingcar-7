package racingcar.view

import racingcar.model.Car

class ResultView {

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.distance)}")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("$MESSAGE_WINNERS: ${winners.joinToString(", ")}")
    }

    companion object {
        const val MESSAGE_WINNERS = "최종 우승자"
    }
}