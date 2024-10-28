package racingcar

class Round(carNames: List<String>) {
    private var cars: MutableList<Car> = carNames.map { Car(it) }.toMutableList()

    fun start() {
        cars.forEach { it.moveForward() }
    }

    fun printRound() {
        cars.forEach { println(it.getStatus()) }
        println()
    }

    fun getWinners(): List<String> {
        val maxPosition = findMaxPosition()
        return cars.filter { it.getPosition() == maxPosition }.map { it.getName() }
    }

    private fun findMaxPosition(): Int {
        val winnerCar = cars.maxBy { it.getPosition() }
        return winnerCar.getPosition()
    }
}