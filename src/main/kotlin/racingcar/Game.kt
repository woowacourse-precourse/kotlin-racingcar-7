package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class Game(
    private val cars: List<Car>,
    private val gameCount: Int,
) {
    private val winners = mutableMapOf<String, Int>()

    fun start() {
        println(GAME_START_TEXT)
        repeat(gameCount) {
            processGame(cars)
        }
    }

    fun printWinnerResult() {
        val winners = calculateWinners()
        val winnersName = winners.joinKeysAsString()
        val winnerResultText =
            "${InputOutputText.FINAL_WINNERS} ${Delimiters.CAR_NAME_CONTENT_DELIMITER} $winnersName"
        println(winnerResultText)
    }

    private fun processGame(cars: List<Car>) {
        carRandomMove(cars)
        cars.forEach { car ->
            printEachGame(car)
            saveScore(car)
        }
        println()
    }

    private fun carRandomMove(cars: List<Car>) {
        cars.forEach { car ->
            val randomNumber = pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX)
            car.moveForwardOrNothing(randomNumber)
        }
    }

    private fun printEachGame(car: Car) {
        val forwardCount = car.forwardCount
        val forwardDashText = CAR_FORWARD_DASH.repeat(forwardCount)
        val eachGameResultText =
            "${car.name} ${Delimiters.CAR_NAME_CONTENT_DELIMITER} $forwardDashText"
        println(eachGameResultText)
    }

    private fun saveScore(car: Car) {
        winners[car.name] = car.forwardCount
    }

    private fun calculateWinners(): Map<String, Int> {
        val winnerScore = winners.maxBy { it.value }
        val winners = winners.filter { it.value == winnerScore.value }
        return winners
    }

    companion object {
        private const val RANDOM_NUMBER_MIN = 0
        private const val RANDOM_NUMBER_MAX = 9
        private const val CAR_FORWARD_DASH = "-"
        private const val GAME_START_TEXT = "\n실행결과"
    }
}

private fun Map<String, Int>.joinKeysAsString() =
    this.keys.joinToString(Delimiters.NAME_DELIMITER) {
        it
    }
