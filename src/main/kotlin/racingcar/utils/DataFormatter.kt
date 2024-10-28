package racingcar.utils

import racingcar.model.Car

class DataFormatter {

    fun getCarList(input: String): List<Car> {
        val carNames = input.splitByDelimiter().removeWhiteSpace().removeEmptyElements()
        validateCarNames(carNames)
        return carNames.toCarList()
    }

    fun getTimes(times: String): Int {
        val parsedTimes = times.toIntOrNull() ?: throw IllegalArgumentException(TIMES_PARSE_ERROR)
        require(parsedTimes > 0) { TIMES_NON_POSITIVE_ERROR }
        return parsedTimes
    }

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
        require(isNotEmptyList(carNames)) { CAR_NAME_BLANK_ERROR }
        require(isCarNamesLengthValid(carNames)) { CAR_NAME_LENGTH_ERROR }
        require(isUniqueCarNames(carNames)) { CAR_NAME_DUPLICATE_ERROR }
    }

    companion object ErrorMessage {
        const val CAR_NAME_LENGTH_ERROR = "자동차 이름은 5자 이하로 입력해 주세요."
        const val CAR_NAME_BLANK_ERROR = "자동차 이름을 입력해 주세요."
        const val CAR_NAME_DUPLICATE_ERROR = "자동차 이름이 중복되었습니다."
        const val TIMES_PARSE_ERROR = "횟수는 숫자로 입력해 주세요."
        const val TIMES_NON_POSITIVE_ERROR = "횟수는 1 이상의 숫자로 입력해 주세요."
    }
}