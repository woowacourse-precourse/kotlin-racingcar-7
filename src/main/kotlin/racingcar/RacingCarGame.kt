package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class RacingCarGame(
    private val cars: List<Car>,
    private val gameCount: Int,
) {
    fun start() {
        repeat(gameCount) {
            processGame()
        }
    }

    private fun processGame() {
        cars.forEach { car ->
            val randomNumber = pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX)
            car.moveForwardAndStop(randomNumber)
        }
    }

    companion object {
        private const val RANDOM_NUMBER_MIN = 0
        private const val RANDOM_NUMBER_MAX = 9
    }
}
