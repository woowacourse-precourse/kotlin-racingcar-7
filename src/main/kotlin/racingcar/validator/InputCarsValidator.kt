package racingcar.validator

object InputCarsValidator {
    fun validate(input: String) {
        val names = input.split(',').map { it }

        require(names.all { it.isNotEmpty() }) { NO_PARTICIPANT }
        require(names.all { it.length <= 5 }) { OVER_FIVE_LENGTH }
    }

    private const val NO_PARTICIPANT = "자동차 이름은 공백이 될 수 없습니다."
    private const val OVER_FIVE_LENGTH = "이름은 5글자 이하여야 합니다."
}