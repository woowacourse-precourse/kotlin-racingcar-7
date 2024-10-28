package racingcar.util

object CarNameValidator {

    fun validateLength(carName: String) {
        // 이모티콘인 경우에도 5글자 이하만 가능하도록 설정
        if (carName.codePointCount(0, carName.length) > 5 || carName.isBlank()) {
            throw IllegalArgumentException("${ErrorMessages.INVALID_CAR_NAME_LENGTH_ERROR}$carName")
        }
    }

    fun validateDuplicate(carNameList: List<String>) {
        if (carNameList.size != carNameList.distinct().size) {
            throw IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_DUPLICATE_ERROR)
        }
    }

}