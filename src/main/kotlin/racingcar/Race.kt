package racingcar

class Race(private val cars: List<Car>, private val rounds: Int) {
    fun start() {
        repeat(rounds) {
            triggerRound()
            printRoundResult()
        }
    }

    private fun triggerRound() {
        cars.forEach { it.moveToForward() }
    }

    private fun printRoundResult() {
        cars.forEach { car ->
            println("${car.name} : ${car.getCurrentProgress()}")
        }
        println()
    }
}
