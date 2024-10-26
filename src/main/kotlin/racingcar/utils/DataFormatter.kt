package racingcar.utils

import racingcar.model.Car

class DataFormatter {

    fun getCarList(input: String): List<Car> {
        val carNames = input.splitByDelimiter()
        require(validateCarNames(carNames))
        return carNames.toCarList()
    }

    fun getTimes(times: String): Int = times.toIntOrNull() ?: throw IllegalArgumentException()

    fun getWinner(cars: List<Car>): String {
        val maxMove = cars.maxOf { it.move.length }
        val winners = cars.filter { it.move.length == maxMove }.map { it.name }
        return winners.joinToString()
    }

    private fun String.splitByDelimiter() = this.split(",").map { it.trim() }

    private fun List<String>.toCarList(): List<Car> = this.map { Car(it, StringBuilder()) }

    private fun validateCarNames(carNames: List<String>) = carNames.any { it.length <= 5 }
}