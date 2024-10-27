package racingcar

class Car(
    val name: String,
) {
    var forwardCount = 0
        private set

    fun moveForwardAndStop(randomNumber: Int) {
        if (randomNumber.canMoveForward()) {
            moveForward()
        }
    }

    private fun moveForward() {
        forwardCount++
    }

    private fun Int.canMoveForward(): Boolean = this >= MIN_VALUE_TO_MOVE_CAR
}

private const val MIN_VALUE_TO_MOVE_CAR = 4
