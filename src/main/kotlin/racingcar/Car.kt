package racingcar

data class Car(
    val name: String,
    private var _position: Int = 0
) {
    val position get() = _position

    fun tryMove(tryNumber: Int) {
        if (tryNumber >= 4) _position++
    }
}