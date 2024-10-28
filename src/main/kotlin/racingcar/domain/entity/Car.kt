package racingcar.domain.entity

data class Car(
    val name: String,
    private var _position: Int = INIT_POSITION
) {
    init {
        validateCarNamesLength(name)
    }

    val position get() = _position

    fun tryMove(tryNumber: Int) {
        validateTryNumberRange(tryNumber)
        if (tryNumber >= MOVE_NUMBER_LIMIT) _position++
    }

    private fun validateTryNumberRange(tryNumber: Int) {
        require(tryNumber >= MIN_TRY_NUMBER) { println(INVALID_MIN_TRY_NUMBER_ERROR) }
        require(tryNumber <= MAX_TRY_NUMBER) { println(INVALID_MAX_TRY_NUMBER_ERROR) }
    }

    private fun validateCarNamesLength(name: String) =
        require(name.length <= MAX_NAME_COUNT) { println(OVER_NAME_COUNT_MESSAGE) }

    companion object {
        private const val INIT_POSITION = 0
        private const val MOVE_NUMBER_LIMIT = 4
        private const val MAX_TRY_NUMBER = 9
        private const val MIN_TRY_NUMBER = 0
        private const val INVALID_MIN_TRY_NUMBER_ERROR = "이동에 사용하는 숫자는 0이상 숫자입니다."
        private const val INVALID_MAX_TRY_NUMBER_ERROR = "이동에 사용하는 숫자는 9이하 숫자입니다 "
        private const val OVER_NAME_COUNT_MESSAGE = "자동차 이름을 5글자 이하로 작성해주세요!"
        private const val MAX_NAME_COUNT = 5
    }
}