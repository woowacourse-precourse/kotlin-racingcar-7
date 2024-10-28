package racingcar.model

sealed class MoveState {
    data class Movable(val playCount: Int) : MoveState()
    data object Immovable : MoveState()
}