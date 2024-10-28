package racingcar

class WinnerFinder {
    fun findWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.prgress } ?: return emptyList()
        return cars.filter { it.prgress == maxPosition }
    }
}
