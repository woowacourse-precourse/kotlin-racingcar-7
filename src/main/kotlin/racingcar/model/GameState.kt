package racingcar.model

import racingcar.model.CarRacingState.PlayerState

data class GameState(
    val players: MutableList<PlayerState>,
    var playCount: Int
)