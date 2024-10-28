package racingcar

import camp.nextstep.edu.missionutils.Console

class GongBaekRacer {
    fun start() {
        val participatedCarNames = nominateCarNames()
        val participatedCars = participatedCarNames.map { Car(it) }
        val totalRounds = selectTotalRound()

        val race = Race(participatedCars, totalRounds)
        race.start()

        val winnerChecker = WinnerFinder()
        val winners = winnerChecker.findWinners(participatedCars)
        printWinners(winners)
    }

    private fun nominateCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()
        return input.split(",").map {
            require(it.length <= 5) { INVALID_INPUT_MESSAGE }
            it.trim()
        }
    }

    private fun selectTotalRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine().toIntOrNull() ?: throw IllegalArgumentException(INVALID_INPUT_MESSAGE)
    }

    private fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("최종 우승자 : $winnerNames")
    }

    companion object {
        private const val INVALID_INPUT_MESSAGE = "유효하지 않은 입력입니다."
    }
}