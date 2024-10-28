package racingcar.model

import racingcar.utils.Validator


data class Car(val name: String, var position: Int = 0) {
    init {
        Validator.validateCarNameLength(name)
    }

    fun move() {
        position++
    }
}