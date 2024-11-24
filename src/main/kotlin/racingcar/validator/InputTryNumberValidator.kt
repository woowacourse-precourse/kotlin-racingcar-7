package racingcar.validator

object InputTryNumberValidator {
    fun validate(input: String) {
        require(input.all { it.isDigit() }) { NOT_DIGIT }
        require(input.toInt() > 0) { SHOULD_BE_OVER_ZERO }
    }

    private const val NOT_DIGIT = "시도 횟수가 유효한 숫자 형식이 아닙니다."
    private const val SHOULD_BE_OVER_ZERO = "시도 횟수가 0 이상이어야 합니다."
}