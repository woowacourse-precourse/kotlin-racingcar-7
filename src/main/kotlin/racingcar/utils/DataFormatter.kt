package racingcar.utils

import racingcar.model.Car

class DataFormatter {

    fun getCarList(input: String): List<Car> {
        val carNames = input.splitByDelimiter().removeWhiteSpace().removeEmptyElements()
        validateCarNames(carNames)
        return carNames.toCarList()
    }

    fun getTimes(times: String): Int = times.toIntOrNull() ?: throw IllegalArgumentException()

    fun getWinner(cars: List<Car>): String {
        val maxMove = cars.maxOf { it.move.length }
        val winners = cars.filter { it.move.length == maxMove }.map { it.name }
        return winners.joinToString()
    }

    private fun String.splitByDelimiter() = this.split(",")

    private fun List<String>.removeWhiteSpace() = this.map { it.trim() }

    private fun List<String>.removeEmptyElements() = this.filter { it.isNotEmpty() }

    private fun List<String>.toCarList(): List<Car> = this.map { Car(name = it) }

    private fun isNotEmptyList(list: List<String>) = list.isNotEmpty()

    private fun isCarNamesLengthValid(carNames: List<String>) = !carNames.any { it.length > 5 }

    private fun isUniqueCarNames(carNames: List<String>) = carNames.distinct().size == carNames.size

    private fun validateCarNames(carNames: List<String>) {
        require(isNotEmptyList(carNames))
        require(isCarNamesLengthValid(carNames))
        require(isUniqueCarNames(carNames))
    }
}