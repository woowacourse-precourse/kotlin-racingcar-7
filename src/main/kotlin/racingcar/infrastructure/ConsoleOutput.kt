package racingcar.infrastructure

import racingcar.domain.Car

class ConsoleOutput {
    fun showRoundResult(cars: List<Car>) {
        var result = ""
        for (car in cars) {
            val carName: String = car.name
            val carDistance: String = ONE_STEP.repeat(car.distance)
            result += "$carName : $carDistance\n"
        }
        println(result)
    }

    fun showWinners(winners: List<String>) {
        println(winners.joinToString(DELIMITER))
    }

    companion object {
        private const val ONE_STEP = "-"
        private const val DELIMITER = ","
    }
}