package racingcar.model

class Car(val name: String) {
    var position: Int = INITIAL_VALUE
        private set

    fun moveForward() {
        position++
    }

    companion object {
        private const val INITIAL_VALUE = 0
    }
}
