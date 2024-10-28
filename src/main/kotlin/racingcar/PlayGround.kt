package racingcar

import racingcar.constans.Constants.MESSAGE_RESULT
import racingcar.model.CarRacingState.PlayResultState
import racingcar.model.CarRacingState.PlayerState
import racingcar.reducer.PlayerStateReducer
import racingcar.sam.MoveCountFactory

class PlayGround(
    private val playerStateReducer: PlayerStateReducer,
    private val factory: MoveCountFactory
) {

    fun play(players: List<PlayerState>, playCount: Int): PlayResultState {
        var state = players
        println(MESSAGE_RESULT)

        repeat(playCount) {
            state = reduceState(state)
            printExecutionByPhase(state)
        }

        return PlayResultState(state)
    }

    private fun reduceState(players: List<PlayerState>): List<PlayerState> {
        return players.map { player ->
            val moveCount = factory()
            playerStateReducer(moveCount, player)
        }
    }

    private fun printExecutionByPhase(players: List<PlayerState>) {
        players.map { it.printExecutionByPhase() }
        println()
    }
}
