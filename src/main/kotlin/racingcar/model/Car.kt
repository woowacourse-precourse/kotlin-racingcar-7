package racingcar.model

import racingcar.util.ConstantsUtil.CAR_INITIAL_POSITION
import racingcar.util.ValidatorUtil.validateCarLength
import racingcar.util.ValidatorUtil.validateCarName

data class Car(
    val name: String,
    var position: Int = CAR_INITIAL_POSITION
) {

    init {
        validateCarLength(name.length)
        validateCarName(name)
    }

    fun move() {
        position++
    }
}
