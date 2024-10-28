package racingcar.model

class Car(
    val name: String,
    initialPosition: Int = INITIAL_VALUE
) {
    var position: Int = initialPosition
        private set

    fun moveForward() {
        position++
    }

    companion object {
        private const val INITIAL_VALUE = 0
    }
}
