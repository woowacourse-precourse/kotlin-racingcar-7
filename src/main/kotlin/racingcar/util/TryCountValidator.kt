package racingcar.util

object TryCountValidator {

    const val INVALID_INPUT_TRY_COUNT = "유효하지 않는 입력 형식입니다."

    fun validateTryCount(tryCount: String) {
        val count = tryCount.toIntOrNull()
        if (count == null || count <= 0) {
            throw IllegalArgumentException(INVALID_INPUT_TRY_COUNT)
        }
    }
}