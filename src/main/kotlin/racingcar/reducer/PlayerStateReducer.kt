package racingcar.reducer

import racingcar.constans.Constants.MIN_MOVE_COUNT
import racingcar.model.MoveState
import racingcar.model.CarRacingState.PlayerState

class PlayerStateReducer : Reducer<Int, PlayerState> {
    override fun invoke(mutation: Int, state: PlayerState): PlayerState {
        return when (getMoveState(mutation)) {
            is MoveState.Movable -> state.copy(position = state.position + mutation)
            is MoveState.Immovable -> state
        }
    }

    private fun getMoveState(moveCount: Int): MoveState {
        return if (moveCount >= MIN_MOVE_COUNT) {
            MoveState.Movable(moveCount)
        } else {
            MoveState.Immovable
        }
    }
}
