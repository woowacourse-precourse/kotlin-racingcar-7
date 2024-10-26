package racingcar.domain.car

import racingcar.domain.numbergenerator.NumberGenerator

private const val MOVE_SIGN = "-"
private const val START_POSITION = 0
private const val MOVABLE_LOWER_BOUND = 4

class Car(val name: String) {
    var position: Int = START_POSITION
        private set

    fun move(numberGenerator: NumberGenerator) {
        if (isMovable(numberGenerator.generateNumber())) {
            this.position++
        }
    }

    private fun isMovable(number: Int) = number >= MOVABLE_LOWER_BOUND

    private fun showPosition(): String {
        return buildString {
            repeat(position) {
                append(MOVE_SIGN)
            }
        }
    }

    override fun toString(): String {
        return "$name : ${showPosition()}"
    }
}