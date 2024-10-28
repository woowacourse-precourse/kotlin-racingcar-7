package racingcar

class Car(
    val name: String,
) {
    var forwardCount = 0
        private set

    fun moveForwardOrNothing(randomNumber: Int) {
        if (randomNumber.canMoveForward()) {
            moveForward()
        }
    }

    private fun moveForward() {
        forwardCount++
    }

    private fun Int.canMoveForward(): Boolean = this >= MIN_VALUE_TO_MOVE_CAR

    companion object {
        private const val MIN_VALUE_TO_MOVE_CAR = 4
    }
}

fun List<String>.asCar(): List<Car> = this.map { Car(it) }
