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
}