package racingcar.validator

object InputCarsValidator {
    fun validate(input: String) {
        val names = input.split(',').map { it }

        require(names.isNotEmpty()) { NO_PARTICIPANT }
        require(names.all { it.length <= 5 }) { OVER_FIVE_LENGTH }
    }

    private const val NO_PARTICIPANT = "자동차가 하나 이상 있어야 합니다."
    private const val OVER_FIVE_LENGTH = "이름은 5글자 이하여야 합니다."
}