package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingCar(val name: String) {
    var moveCount = 0

    companion object {
        private const val MOVING_FORWARD: Int = 4
    }

    fun takeTurn() {
        val randomValue = Randoms.pickNumberInRange(0, 9)
        if (randomValue >= MOVING_FORWARD) {
            moveCount++
        }
    }
}