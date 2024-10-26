package racingcar.model

import racingcar.constans.Constants.MIN_MOVE_COUNT

sealed class MoveState{
    data class Movable(val playCount: Int): MoveState()
    data object Immovable: MoveState()

    companion object{
        fun fromMoveCount(moveCount: Int): MoveState {
            return if (moveCount >= MIN_MOVE_COUNT) {
                Movable(moveCount)
            } else {
                Immovable
            }
        }
    }
}