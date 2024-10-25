package racingcar.ui

import racingcar.domain.entity.Car

class ResultOutput {
    fun printRaceResult(cars: List<Car>) {
        cars.forEach { car ->
            val positionResult = POSITION_SYMBOL.repeat(car.position)
            println("${car.name}$CAR_RESULT_SEPARATOR$positionResult")
        }
        println()
    }

    fun printWinners(winnersName: List<String>) {
        val winnersResult = winnersName.joinToString(DELIMITER)
        println("$FINAL_WINNER_MESSAGE$winnersResult")
    }

    companion object {
        private const val POSITION_SYMBOL = "-"
        private const val CAR_RESULT_SEPARATOR = " : "
        private const val DELIMITER = ","
        private const val FINAL_WINNER_MESSAGE = "최종 우승자 : "
    }
}