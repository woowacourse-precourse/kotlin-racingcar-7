package racingcar.model

data class Car(
    val name: String,
    var distance: Int = 0
) {
    fun moveForward() {
        distance += 1
    }
}