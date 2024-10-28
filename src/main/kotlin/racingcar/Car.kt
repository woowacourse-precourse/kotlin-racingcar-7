package racingcar

data class Car(
    val name: String,
    private val initialPosition: Int = INITIAL_POSITION
) {
    private var currentPosition = initialPosition

    fun move() {
        currentPosition++
    }

    fun getCurrentPosition(): Int = currentPosition

    companion object {
        private const val INITIAL_POSITION = 0
    }
}