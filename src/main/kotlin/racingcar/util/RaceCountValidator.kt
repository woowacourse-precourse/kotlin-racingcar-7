package racingcar.util

object RaceCountValidator {

    fun validatePositiveInteger(input: String): Int {
        return try {
            validateInteger(input)
            val raceCount = input.toInt()
            if (raceCount <= 0) {
                throw IllegalArgumentException("${ErrorMessages.INVALID_RACE_COUNT_POSITIVE_INTEGER_ERROR}$raceCount")
            }
            raceCount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessages.INVALID_RACE_COUNT_FORMAT_ERROR)
        }
    }

    fun validateNumberSize(raceCount: Int) {
        if (raceCount > 100000) {
            throw IllegalArgumentException(ErrorMessages.INPUT_EXCEEDS_RACE_COUNT_LIMIT_ERROR)
        }
    }

    private fun validateInteger(input: String) {
        val doubleValue = input.toDouble()
        if (doubleValue % 1 != 0.0) {
            throw IllegalArgumentException("${ErrorMessages.INVALID_RACE_COUNT_DECIMAL_ERROR}$input")
        }
    }
}