package racingcar.model

import racingcar.constant.Message.CAR_MOVING_MIN_NUMBER

data class Car(
    val name: String,
    var moving: Int = 0
) {
    fun move(value: Int) {
        if (value >= CAR_MOVING_MIN_NUMBER) moving++
    }
}