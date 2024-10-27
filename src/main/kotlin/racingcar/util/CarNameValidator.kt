package racingcar.util

object CarNameValidator {

    private const val INVALID_LENGTH_ERROR = "자동차 이름은 1자 이상, 5자 이하만 가능합니다: "

    fun validateLength(carName: String) {
        // 이모티콘인 경우에도 5글자 이하만 가능하도록 설정
        if (carName.codePointCount(0, carName.length) > 5 || carName.isBlank()) {
            throw IllegalArgumentException("$INVALID_LENGTH_ERROR$carName")
        }
    }

}