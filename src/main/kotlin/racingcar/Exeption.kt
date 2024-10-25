package racingcar

class Exeption {

    fun carNameExeption(carName: List<String>) {

        when {
            carName.any { it.length > NAME_MAX_LENGTH } -> throw IllegalArgumentException(ERROR_NAME_TOO_LONG)
            carName.any { it.isBlank() } -> throw IllegalArgumentException(ERROR_NAME_EMPTY)
        }
    }

    fun moveCountExeption(moveCount: String) {

        moveCount.toLongOrNull() ?: throw IllegalArgumentException(ERROR_NOT_NUMBER)
        moveCount.toIntOrNull() ?: throw IllegalArgumentException(ERROR_OUT_OF_INT_RANGE)
    }

    companion object {
        const val NAME_MAX_LENGTH = 5
        const val ERROR_NAME_TOO_LONG = "자동차 이름은 5글자가 넘어가면 안됩니다."
        const val ERROR_NAME_EMPTY = "자동차 이름이 공백이면 안됩니다."
        const val ERROR_NOT_NUMBER = "시도 횟수가 숫자가 아닙니다."
        const val ERROR_OUT_OF_INT_RANGE = "시도 횟수가 너무 큽니다"
    }
}