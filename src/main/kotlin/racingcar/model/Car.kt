package racingcar.model

import racingcar.utils.ErrorMessages

data class Car(val name: String, var position: Int = 0) {
    init {
        require(name.length <= 5) { ErrorMessages.NAME_LENGTH_ERROR }
        require(name.isNotEmpty()) { ErrorMessages.NAME_EMPTY_ERROR }
    }

    fun move() {
        position++
    }
}