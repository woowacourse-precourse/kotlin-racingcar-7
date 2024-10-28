package racingcar.Model

class Car(val name: String) {
    init {
        require(name.length <= 5) { name + CANT_BE_LONGER_THAN_5 }
    }

    var position: Int = 0
        private set

    fun moveForward(randomValue: Int) {
        if (randomValue >= MOVING_POINT) {
            position++
        }
    }

    companion object {
        private const val CANT_BE_LONGER_THAN_5 = " -> 자동차 이름은 5자 이하이어야 합니다."
        private const val MOVING_POINT = 4
    }
}