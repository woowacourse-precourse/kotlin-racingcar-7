package racingcar.utils

import racingcar.model.Car

object Validator {

    fun validateRounds(input: String?): Int {
        return when {
            input.isNullOrEmpty() -> throw IllegalArgumentException(ErrorMessages.ROUND_NUMBER_ERROR)
            input.toIntOrNull() == null -> throw IllegalArgumentException(ErrorMessages.ROUND_NUMBER_ERROR)
            input.toInt() <= 0 -> throw IllegalArgumentException(ErrorMessages.ROUND_NUMBER_ERROR)
            else -> input.toInt()
        }
    }


    // 자동차 이름 중복 여부 검증
    fun validateCarNames(cars: List<Car>) {
        val carNames = cars.map { it.name }

        require(carNames.size == carNames.distinct().size) { ErrorMessages.NAME_DUPLICATE_ERROR }
    }

    // 자동차 이름 길이 검증
    fun validateCarNameLength(name: String) {
        require(name.length <= 5) { ErrorMessages.NAME_LENGTH_ERROR }
        require(name.isNotEmpty()) { ErrorMessages.NAME_EMPTY_ERROR }
    }


}