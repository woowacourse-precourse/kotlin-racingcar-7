package racingcar

class Validation {

    fun validateCarName(carName: List<Car>) {
        checkCarNameLength(carName)
        checkCarNameBlank(carName)
        checkOnlyOneCar(carName)
        checkCarNameDuplication(carName)
    }

    fun validateRoundCount(inputRoundCount: String) {
        checkRoundCountNotNumber(inputRoundCount)
        checkRoundCountNegativeInteger(inputRoundCount)
    }

    fun checkCarNameLength(carName: List<Car>) {
        carName.forEach {
            if (it.name.length > MAX_CAR_NAME_LENGTH) {
                throw IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE)
            }
        }
    }

    fun checkCarNameBlank(carName: List<Car>) {
        if (carName.any { it.name.isBlank() }) {
            throw IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE)
        }
    }

    fun checkOnlyOneCar(carName: List<Car>) {
        if (carName.size == ONLY_ONE_CAR) {
            throw IllegalArgumentException(CAR_NAME_ONLY_ONE_ERROR_MESSAGE)
        }
    }

    fun checkContainBlank(carName: List<Car>) {
        carName.forEach {
            if (it.name.contains(BLANK)) {
                throw IllegalArgumentException(CAR_NAME_CONTAIN_BLANK_ERROR_MESSAGE)
            }
        }
    }

    fun checkCarNameDuplication(carName: List<Car>) {
        val carNames = carName.map { it.name }
        if (carNames.distinct().size != carNames.size) {
            throw IllegalArgumentException(CAR_NAME_DUPLICATED_ERROR_MESSAGE)
        }
    }

    fun checkRoundCountNotNumber(inputRoundCount: String) {
        if (inputRoundCountIsNotInt(inputRoundCount)) {
            throw IllegalArgumentException(ROUND_COUNT_NOT_NUMBER_ERROR_MESSAGE)
        }
    }

    fun checkRoundCountNegativeInteger(inputRoundCount: String) {
        val roundCount = inputRoundCount.toInt()
        if (roundCount < MIN_ROUND_COUNT) throw IllegalArgumentException(ROUND_COUNT_NEGATIVE_INTEGER_ERROR_MESSAGE)
    }

    private fun inputRoundCountIsNotInt(inputRoundCount: String): Boolean {
        return inputRoundCount.toIntOrNull() == null
    }
}