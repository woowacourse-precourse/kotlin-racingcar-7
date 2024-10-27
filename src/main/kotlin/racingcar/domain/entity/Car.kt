package racingcar.domain.entity

data class Car(
    val name: String,
    private var _position: Int = INIT_POSITION
) {
    val position get() = _position

    fun tryMove(tryNumber: Int) {
        validateTryNumber(tryNumber)
        if (tryNumber >= MOVE_NUMBER_LIMIT) _position++
    }

    private fun validateTryNumber(tryNumber: Int) {
        val numberRange = MIN_TRY_NUMBER..MAX_TRY_NUMBER
        require(numberRange.contains(tryNumber)) { println(INVALID_TRY_NUMBER_RANGE_ERROR) }
    }

    companion object {
        private const val INIT_POSITION = 0
        private const val MOVE_NUMBER_LIMIT = 4
        private const val MAX_TRY_NUMBER = 9
        private const val MIN_TRY_NUMBER = 0
        private const val INVALID_TRY_NUMBER_RANGE_ERROR = "이동에 사용하는 숫자는 0~9사이의 정수입니다."
    }
}