package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constans.Constants.MAX_RANDOM_NUMBER
import racingcar.constans.Constants.MESSAGE_RESULT
import racingcar.constans.Constants.MIN_RANDOM_NUMBER
import racingcar.model.CarRacingState.PlayerState
import racingcar.model.CarRacingState.PlayResultState
import racingcar.reducer.PlayerStateReducer

class PlayGround(private val playerStateReducer: PlayerStateReducer) {

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
            val moveCount = createMoveCount()
            playerStateReducer(moveCount, player)
        }
    }

    private fun printExecutionByPhase(players: List<PlayerState>) {
        players.map { it.printExecutionByPhase() }
        println()
    }

    private fun createMoveCount(): Int {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }
}
