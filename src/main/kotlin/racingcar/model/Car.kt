package racingcar.model

import racingcar.utils.NumberGenerator

class Car(private val name: String) {

    private var distance = 0

    val currentDistance: String
        get() = "-".repeat(distance)

    init {
        require(name.isNotEmpty() && name.length <= 5)
    }

    fun getName() = name

    fun canMove(): Boolean {
        return NumberGenerator.generate() >= 4
    }

    fun moveForward() {
        distance++
    }
}