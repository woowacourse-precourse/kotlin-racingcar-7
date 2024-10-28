package racingcar.domain

class Car(
    val carName: String,
    private val randomNumber: RandomNumber
) {

    var distance: String = INITIAL_DISTANCE_VALUE

    init {
        validateCarNameLength(carName)
    }

    fun moveToForward() {
        val randomNumber = randomNumber.generate()
        if (checkMoveOrStop(randomNumber)) {
            distance += DASH
        }
    }

    private fun checkMoveOrStop(randomNumber: Int): Boolean {
        return when (randomNumber) {
            in STOP_START_RANGE..STOP_END_RANGE -> false
            in MOVE_START_RANGE..MOVE_END_RANGE -> true
            else -> throw IllegalArgumentException(RANDOM_NUMBER_RANGE_ERROR_MESSAGE)
        }
    }

    private fun validateCarNameLength(carName: String) =
        require(carName.length <= MAX_CAR_NAME_LENGTH) { CAR_NAME_LENGTH_ERROR_MESSAGE }

    companion object {
        private const val INITIAL_DISTANCE_VALUE = ""
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val STOP_START_RANGE = 0
        private const val STOP_END_RANGE = 3
        private const val MOVE_START_RANGE = 4
        private const val MOVE_END_RANGE = 9
        private const val DASH = "-"
        private const val RANDOM_NUMBER_RANGE_ERROR_MESSAGE = "지정된 범위를 벗어난 랜덤숫자 입니다."
        private const val CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 다섯글자를 넘을 수 없습니다."
    }
}
