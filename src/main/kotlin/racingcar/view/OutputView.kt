package racingcar.view

import racingcar.model.Model

object OutputView {
    fun outputRaceStatus(cars: List<Model>) {
        for (car in cars) {
            val carName = car.name
            val carMoveCount = "-".repeat(car.moveCount)
            println("$carName : $carMoveCount")
        }
    }

    fun outputWinners(winners: List<Model>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("최종 우승자 : $winnerNames")
    }
}