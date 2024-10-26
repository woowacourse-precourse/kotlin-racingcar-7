package racingcar.reducer

import racingcar.model.MoveState
import racingcar.model.CarRacingState.PlayerState

class PlayerStateReducer : Reducer<Int, PlayerState> {
    override fun invoke(mutation: Int, state: PlayerState): PlayerState {
        return when (MoveState.fromMoveCount(mutation)) {
            is MoveState.Movable -> state.copy(position = state.position + mutation)
            is MoveState.Immovable -> state
        }
    }
}
