package racingcar.utils

object Validator {
    fun isValidCarName(carName: String) {
        // 자동차 이름의 길이는 5이하여야 한다.
        if (carName.length > Values.CAR_NAME_LENGTH_LIMIT) throwInvalidStringException(Messages.INVALID_CAR_NAME_LENGTH)

        // 자동차 이름은 문자열 또는 문자열 + 숫자의 형태만 가능하다.
        val regex = Regex("^[A-Za-z가-힣]+[0-9]*+[A-Za-z가-힣]*$")
        if (!regex.matches(carName)) throwInvalidStringException(Messages.INVALID_CAR_NAME)
    }

    fun isValidMoveCount(input: String) {
        val regex = Regex("^\\d+$")
        if (!regex.matches(input)) throwInvalidStringException(Messages.INVALID_MOVE_COUNT)
    }


    private fun throwInvalidStringException(message: String) {
        throw IllegalArgumentException(message)
    }
}