package racingcar.util

object RaceCountValidator {

    private const val INVALID_DECIMAL_ERROR = "소수 입력은 허용되지 않습니다: "
    private const val INVALID_POSITIVE_INTEGER_ERROR = "경주 횟수는 1 이상의 정수여야 합니다: "
    private const val INVALID_RACE_COUNT_FORMAT_ERROR = "유효한 경주 횟수 형식이 아닙니다."
    private const val INPUT_EXCEEDS_LIMIT_ERROR = "100,000 이하의 숫자를 입력해 주세요."

    fun validatePositiveInteger(input: String): Int {
        return try {
            validateInteger(input)
            val raceCount = input.toInt()
            if (raceCount <= 0) {
                throw IllegalArgumentException("$INVALID_POSITIVE_INTEGER_ERROR$raceCount")
            }
            raceCount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_RACE_COUNT_FORMAT_ERROR)
        }
    }

    fun validateNumberSize(raceCount: Int) {
        if (raceCount > 100000) {
            throw IllegalArgumentException(INPUT_EXCEEDS_LIMIT_ERROR)
        }
    }

    private fun validateInteger(input: String) {
        val doubleValue = input.toDouble()
        if (doubleValue % 1 != 0.0) {
            throw IllegalArgumentException("$INVALID_DECIMAL_ERROR$input")
        }
    }
}