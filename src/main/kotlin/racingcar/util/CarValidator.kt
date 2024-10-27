package racingcar.util

object CarValidator {

    const val INVALID_INPUT_CAR_NAME_LENGTH_MESSAGE = "자동차 이름의 길이가 유효하지 않습니다: "
    const val INVALID_INPUT_CAR_NAME_DUPLICATE_MESSAGE = "중복된 자동차 이름이 존재합니다"
    private const val MAX_CAR_NAME_LENGTH = 5

    fun validateCarName(carNames: List<String>) {
        validateCarNameLength(carNames)
        validateCarNameDuplicate(carNames)
    }

    private fun validateCarNameLength(carNames: List<String>) {
        carNames.forEach { carName ->
            if (carName.length > MAX_CAR_NAME_LENGTH || carName.isEmpty()) throw IllegalArgumentException(
                "$INVALID_INPUT_CAR_NAME_LENGTH_MESSAGE$carName"
            )
        }
    }

    private fun validateCarNameDuplicate(carNames: List<String>) {
        if (carNames.size != carNames.distinct().size) throw IllegalArgumentException(INVALID_INPUT_CAR_NAME_DUPLICATE_MESSAGE)
    }
}