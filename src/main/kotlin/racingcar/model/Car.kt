package racingcar.model

import racingcar.enum.RacingRule.*
import racingcar.utils.NumberGenerator

class Car(private val name: String) {

    private var distance = 0

    val currentDistance: String
        get() = DISTANCE.value.repeat(distance)

    init {
        require(name.isNotEmpty() && name.length <= MAX_NAME_LENGTH)
    }

    fun getName() = name

    fun canMove(): Boolean {
        return NumberGenerator.generate() >= MOVE_THRESHOLD
    }

    fun moveForward() {
        distance++
    }


    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MOVE_THRESHOLD = 4
    }
}