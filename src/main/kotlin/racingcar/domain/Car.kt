package racingcar.domain

data class Car(
    val name: String,
) {
    var movedDistance: Int = 0
        private set

    fun moveForward() {
        movedDistance++
    }
}