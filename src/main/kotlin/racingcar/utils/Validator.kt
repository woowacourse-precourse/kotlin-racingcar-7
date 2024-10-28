package racingcar.utils


class Validator {
    fun validateCarNames(carNames: List<String>) {
        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException(VALIDATE_CAR_NAMES)
        }
    }

    fun validateRoundCount(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException(VALIDATE_ROUND_COUNT)
    }

    companion object {
        const val VALIDATE_CAR_NAMES = "자동차 이름을 5자 이하로 입력해주세요."
        const val VALIDATE_ROUND_COUNT = "정수만 입력할 수 있습니다."
    }
}