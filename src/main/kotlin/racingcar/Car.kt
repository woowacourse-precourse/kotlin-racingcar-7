package racingcar

class Car(
    val name: String,
) {
    var forwardCount = 0
        private set

    init {
        name.validateCarNaming()
    }

    fun moveForwardAndStop(randomNumber: Int) {
        if (randomNumber.canMoveForward()) {
            moveForward()
        }
    }

    private fun moveForward() {
        forwardCount++
    }

    private fun String.validateCarNaming() {
        if (this.length > CAR_NAME_MAX_LENGTH) {
            throw IllegalArgumentException(CAR_NAME_MAX_LENGTH_EXCEPTION)
        }
    }

    private fun Int.canMoveForward(): Boolean = this <= MIN_VALUE_TO_MOVE_CAR
}

private const val CAR_NAME_MAX_LENGTH = 5
private const val CAR_NAME_MAX_LENGTH_EXCEPTION = "자동차 이름은 5자 이하만 가능 합니다."
private const val MIN_VALUE_TO_MOVE_CAR = 4
