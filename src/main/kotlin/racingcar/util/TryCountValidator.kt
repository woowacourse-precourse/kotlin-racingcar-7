package racingcar.util

object TryCountValidator {

    const val INVALID_INPUT_TRY_COUNT_MESSAGE = "시도 횟수는 양의 정수여야 합니다."

    fun validateTryCount(tryCount: String) {
        val count = tryCount.toIntOrNull()
        if (count == null || count <= 0) {
            throw IllegalArgumentException(INVALID_INPUT_TRY_COUNT_MESSAGE)
        }
    }
}