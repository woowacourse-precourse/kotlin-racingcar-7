package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class RacingCarGame(
    private val cars: List<Car>,
    private val gameCount: Int,
) {
    private fun processGame(cars: List<Car>) {
        cars.forEach { car ->
            val randomNumber = pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX)
            car.moveForwardAndStop(randomNumber)
        }
        cars.forEach { car ->
            printEachGame(car)
        }
        println()
    }

    private fun printEachGame(car: Car) {
        val forwardCount = car.forwardCount
        val forwardDashText = CAR_FORWARD_DASH.repeat(forwardCount)
        val resultText = "${car.name} ${RacingCarDelimiters.CAR_NAME_DASH_DELIMITER} $forwardDashText"
        println(resultText)
    }

    fun start() {
        repeat(gameCount) {
            processGame(cars)
        }
    }

    companion object {
        private const val RANDOM_NUMBER_MIN = 0
        private const val RANDOM_NUMBER_MAX = 9
        private const val CAR_FORWARD_DASH = "-"
    }
}
