package racingcar.view

import racingcar.message.Other

class OutputWinner {
    fun announceWinner(winner: String) {
        println(Other.WINNER_ANNOUNCEMENT + winner)
    }
}