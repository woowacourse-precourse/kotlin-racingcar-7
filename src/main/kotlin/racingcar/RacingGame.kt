package racingcar

class RacingGame(private val cars: List<Car>, private val tryCount: Int) {

    fun start() {
        repeat(tryCount) {
            cars.forEach { it.move() }
            printCurrentPositions()
        }
    }

    private fun printCurrentPositions() {
        cars.forEach { car ->
            println("${car.name} : ${car.getPositionMarker()}")
        }
        println()
    }

    fun getWinners(): String {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
            .joinToString(", ") { it.name }
    }
}
