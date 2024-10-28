package racingcar.domain

import racingcar.domain.random.RandomNumberGenerator

class Car(
    val carName: CarName,
    private val randomNumberGenerator: RandomNumberGenerator
) {
    var distance = 0
        private set

    fun tryMove() {
        if (canMove()) ++distance
    }

    private fun canMove(): Boolean =
        randomNumberGenerator.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) >= MOVE_THRESHOLD

    companion object {
        private const val MAX_RANDOM_VALUE = 9
        private const val MIN_RANDOM_VALUE = 0
        private const val MOVE_THRESHOLD = 4
    }
}
