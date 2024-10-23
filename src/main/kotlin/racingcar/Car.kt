package racingcar

data class Car(
    val name: String,
    private var _position: Int = INIT_POSITION
) {
    val position get() = _position

    fun tryMove(tryNumber: Int) {
        if (tryNumber >= MOVE_NUMBER_LIMIT) _position++
    }

    companion object {
        private const val INIT_POSITION = 0
        private const val MOVE_NUMBER_LIMIT = 4
    }
}