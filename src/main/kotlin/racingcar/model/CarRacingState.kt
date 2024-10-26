package racingcar.model

import racingcar.constans.Constants.MESSAGE_LAST_WINNER

sealed class CarRacingState {
    data class PlayerState(val playerName: String, var position: Int) : CarRacingState() {
        fun printExecutionByPhase() {
            println("$playerName : ${"-".repeat(position)}")
        }
    }

    data class PlayResultState(val result: List<PlayerState>) : CarRacingState() {
        fun printWinner() {
            val maxScore = result.maxOf { it.position }
            val winners = result
                .filter { it.position == maxScore }
                .map { it.playerName }
            print("$MESSAGE_LAST_WINNER ${winners.joinToString(", ")}")
        }
    }
}