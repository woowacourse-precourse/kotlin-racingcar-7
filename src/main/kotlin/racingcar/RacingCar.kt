package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class RacingCar(val carName: String) {
    var moveCount = 0

    init {
        require(checkCarName(carName))
    }

    companion object {
        private val CAR_NAME_LENGTH_RANGE = 1..5
        fun checkCarName(carName: String): Boolean =
            carName.length in CAR_NAME_LENGTH_RANGE && carName.all { it.isUpperCase() || it.isLowerCase() || it.isDigit() }

        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
        private const val MIN_MOVE_NUMBER = 4
        private const val MOVE_SIGN = "-"
    }

    fun move() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MIN_MOVE_NUMBER) moveCount++
    }

    override fun toString(): String {
        return "$carName : ${MOVE_SIGN.repeat(moveCount)}"
    }
}