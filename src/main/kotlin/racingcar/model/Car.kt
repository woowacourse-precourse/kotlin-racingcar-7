package racingcar.model

import racingcar.util.ConstantsUtil.CAR_INITIAL_POSITION

data class Car(
    val name: String,
    var position: Int = CAR_INITIAL_POSITION
) {

    fun move() {
        position++
    }
}
