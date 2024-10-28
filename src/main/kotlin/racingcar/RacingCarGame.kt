package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class RacingCarGame(
    private val cars: List<Car>,
    private val gameCount: Int,
) {
    private val winners = mutableMapOf<String, Int>()

    init {
        println(GAME_START_TEXT)
    }

    fun start() {
        repeat(gameCount) {
            processGame(cars)
        }
    }

    fun printWinnerResult() {
        val winnerScore = winners.maxBy { it.value }
        val winners = winners.filter { it.value == winnerScore.value }
        val winnersName = winners.joinKeysAsString()
        val winnerResultText =
            "${RacingCarText.FINAL_WINNERS} ${RacingCarDelimiters.CAR_NAME_CONTENT_DELIMITER} $winnersName"
        println(winnerResultText)
    }

    private fun processGame(cars: List<Car>) {
        cars.forEach { car ->
            val randomNumber = pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX)
            car.moveForwardAndStop(randomNumber)
        }
        cars.forEach { car ->
            printEachGame(car)
            saveScore(car)
        }
        println()
    }

    private fun printEachGame(car: Car) {
        val forwardCount = car.forwardCount
        val forwardDashText = CAR_FORWARD_DASH.repeat(forwardCount)
        val resultText =
            "${car.name} ${RacingCarDelimiters.CAR_NAME_CONTENT_DELIMITER} $forwardDashText"
        println(resultText)
    }

    private fun saveScore(car: Car) {
        winners[car.name] = car.forwardCount
    }

    companion object {
        private const val RANDOM_NUMBER_MIN = 0
        private const val RANDOM_NUMBER_MAX = 9
        private const val CAR_FORWARD_DASH = "-"
        private const val GAME_START_TEXT = "\n실행결과"
    }
}

private fun Map<String, Int>.joinKeysAsString() =
    this.keys.joinToString(RacingCarDelimiters.NAME_DELIMITER) {
        it
    }
