package racingcar.view

import racingcar.message.Other

class OutputWinner {
    fun winner(winner: String) {
        println(Other().WINNER_ANNOUNCEMENT + winner)
    }
}