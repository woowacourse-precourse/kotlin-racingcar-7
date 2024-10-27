package racingcar.util

object RaceCountValidator {

    private const val INVALID_INTEGER_ERROR = "소수 입력은 허용되지 않습니다: "
    private const val INVALID_POSITIVE_ERROR = "경주 횟수는 1 이상의 정수여야 합니다: "
    private const val INVALID_NUMBER_FORMAT_ERROR = "유효한 경주 횟수 형식이 아닙니다."

    fun validatePositiveInteger(input: String): Int {
        return try {
            validateInteger(input)
            val raceCount = input.toInt()
            if (raceCount <= 0) {
                throw IllegalArgumentException("$INVALID_POSITIVE_ERROR$raceCount")
            }
            raceCount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_NUMBER_FORMAT_ERROR)
        }
    }

    private fun validateInteger(input: String) {
        val doubleValue = input.toDouble()
        if (doubleValue % 1 != 0.0) {
            throw IllegalArgumentException("$INVALID_INTEGER_ERROR$input")
        }
    }
}