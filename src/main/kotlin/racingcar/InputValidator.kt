package racingcar

class InputValidator {

    companion object {
        const val CAR_NAME_EMPTY_ERROR = "자동차 이름은 하나 이상 입력해야 합니다."
        const val CAR_NAME_BLANK_ERROR = "자동차 이름은 공백일 수 없습니다."
        const val CAR_NAME_TOO_LONG_ERROR = "자동차 이름은 5자 이하이어야 합니다."
        const val TRY_COUNT_ERROR = "시도 횟수는 1 이상이어야 합니다."
    }

    fun validateCarNames(input: List<String>) {
        require(input.isNotEmpty()) { CAR_NAME_EMPTY_ERROR }
        input.forEach { name ->
            require(name.isNotBlank()) { CAR_NAME_BLANK_ERROR }
            require(name.length <= 5) { CAR_NAME_TOO_LONG_ERROR }
        }
    }

    fun validateTryCount(input: Int) {
        require(input > 0) { TRY_COUNT_ERROR }
    }
}