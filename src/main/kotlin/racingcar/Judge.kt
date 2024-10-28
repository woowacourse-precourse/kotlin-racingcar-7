package racingcar

class Judge {

    fun findWinnerName(cars: List<Car>): List<String> {
        val maxForward = cars.maxOfOrNull { it.location } ?: return emptyList()
        return cars.filter { it.location == maxForward }.map { it.name }
    }
}