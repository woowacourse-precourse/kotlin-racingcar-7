package racingcar.view

import racingcar.model.Car

object OutputView {
    fun displayRaceResults(results: List<List<Car>>) {
        results.forEach { race ->
            race.forEach { car ->
                println("${car.name} : ${"-".repeat(car.position)}")
            }
            println()
        }
    }

    fun displayWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("최종 우승자 : $winnerNames")
    }
}