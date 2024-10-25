package racingcar.util

object CarValidator {

    const val INVALID_INPUT_CAR_NAME_LENGTH = "자동차 이름의 길이가 유효하지 않습니다."
    const val INVALID_INPUT_CAR_NAME_DUPLICATE = "중복된 자동차 이름이 존재합니다."

    fun validateCarName(carNames: List<String>) {
        validateCarNameLength(carNames)
        validateCarNameDuplicate(carNames)
    }

    private fun validateCarNameLength(carNames: List<String>) {
        carNames.forEach { carName ->
            if (carName.length > 5 || carName.isEmpty()) throw IllegalArgumentException(
                INVALID_INPUT_CAR_NAME_LENGTH
            )
        }
    }

    private fun validateCarNameDuplicate(carNames: List<String>) {
        if (carNames.size != carNames.distinct().size) throw IllegalArgumentException(INVALID_INPUT_CAR_NAME_DUPLICATE)
    }
}