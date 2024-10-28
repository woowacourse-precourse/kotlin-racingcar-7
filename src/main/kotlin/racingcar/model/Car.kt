package racingcar.model

import racingcar.utils.ErrorMessages

data class Car(val name: String, var position: Int = 0) {
    init {
        if (name.length > 5) {
            throw IllegalArgumentException(ErrorMessages.NAME_LENGTH_ERROR)
        }
    }

    fun move() {
        position++
    }
}