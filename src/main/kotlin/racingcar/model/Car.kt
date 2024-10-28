package racingcar.model

class Car(val name: String) {
    companion object {
        private const val INITIAL_VALUE = 0
    }

    var position: Int = INITIAL_VALUE
        private set

    fun moveForward() {
        position++
    }
}
