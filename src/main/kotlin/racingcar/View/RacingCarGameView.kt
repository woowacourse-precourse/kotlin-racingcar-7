package racingcar


class RacingCarGameView(private val racingCars: List<RacingCar>) {
    fun printTurnResult() {
        racingCars.forEach {
            print(it.name+" : ")
            printMoveCount(it.moveCount)
        }
        println()
    }

    private fun printMoveCount(moveCount: Int) {
        for (i in 1..moveCount) {
            print("-")
        }
        println()
    }

    fun printTotalResult() {
        val maxMoveCount = racingCars.maxOf { it.moveCount }
        val winners = racingCars.filter{it.moveCount == maxMoveCount}
        val winnersName = winners.joinToString(",") { it.name }
        println("최종 우승자 : $winnersName")
    }
}