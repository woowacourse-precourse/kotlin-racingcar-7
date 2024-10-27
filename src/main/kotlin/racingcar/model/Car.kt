package racingcar.model

import racingcar.constants.Constants.MOVE
import racingcar.constants.Constants.STOP

data class Car(val carName: String) {
    val moves = mutableListOf<String>()

    fun move(isMove: Boolean) {
        when (isMove) {
            true -> moves.add(MOVE)
            false -> moves.add(STOP)
        }
    }

    fun getMoveCount(): Int {
        return moves.count { it == MOVE }
    }
}
