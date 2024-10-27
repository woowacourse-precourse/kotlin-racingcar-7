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
}