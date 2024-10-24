package racingcar.model

import racingcar.constants.Constants.MOVE
import racingcar.constants.Constants.STOP

class Move {
    fun moveOrStop(numberList: List<Int>): List<String> {
        val moveList = mutableListOf<String>()
        repeat(numberList.size) {
            moveList.add(STOP)
        }
        for (i in numberList.indices) {
            if (numberList[i] > 3) {
                moveList[i] = MOVE
            }
        }

        return moveList
    }
}
