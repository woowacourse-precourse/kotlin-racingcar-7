package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class RacingCar(val carName: String) {
    var moveCount = 0

    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
        private const val MOVE_SIGN = "-"
    }

    fun move() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= 4) moveCount++
    }

    override fun toString(): String {
        return "$carName : ${MOVE_SIGN.repeat(moveCount)}"
    }
}