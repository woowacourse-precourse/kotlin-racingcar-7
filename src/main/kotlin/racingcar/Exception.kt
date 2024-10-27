package racingcar

class Exception {

    fun carNameException(carName: List<String>) {
        when {
            carName.any { it.length > NAME_MAX_LENGTH } -> throw IllegalArgumentException(ERROR_NAME_TOO_LONG)
            carName.any { it.isBlank() } -> throw IllegalArgumentException(ERROR_NAME_EMPTY)
        }
    }

    fun moveCountException(moveCount: String) {
        moveCount.toLongOrNull() ?: throw IllegalArgumentException(ERROR_NOT_NUMBER)
        moveCount.toIntOrNull() ?: throw IllegalArgumentException(ERROR_OUT_OF_INT_RANGE)

        when {
            moveCount.isBlank() -> throw IllegalArgumentException(ERROR_BLANK_NUMBER)
            moveCount == ZERO -> throw IllegalArgumentException(ERROR_ZERO)
            moveCount.startsWith(NEGATIVE_SIGN) -> throw IllegalArgumentException(ERROR_NEGATIVE_NUMBER)
        }
    }

    private companion object {
        const val NAME_MAX_LENGTH = 5
        const val ZERO = "0"
        const val NEGATIVE_SIGN = "-"
        const val ERROR_NAME_TOO_LONG = "자동차 이름은 5글자 이내여야 합니다."
        const val ERROR_NAME_EMPTY = "자동차 이름이 공백이면 안됩니다."
        const val ERROR_NOT_NUMBER = "시도 횟수는 정수형 숫자여야 합니다."
        const val ERROR_OUT_OF_INT_RANGE = "시도 횟수가 너무 큽니다."
        const val ERROR_BLANK_NUMBER = "시도 횟수는 비어있지 않아야 합니다."
        const val ERROR_ZERO = "시도 횟수는 1 이상이어야 합니다."
        const val ERROR_NEGATIVE_NUMBER = "시도 횟수는 양수여야 합니다."
    }
}