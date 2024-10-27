package racingcar.view

import racingcar.model.Car

object OutputView {
    fun displayRaceResults(results: List<List<Car>>) {
        results.forEach { race ->
            displaySingleRaceResult(race)
            println()
        }
    }

    private fun displaySingleRaceResult(race: List<Car>) {
        race.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }

    fun displayWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("최종 우승자 : $winnerNames")
    }
}
