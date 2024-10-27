package racingcar

class Judge {

    fun findWinnerName(cars: List<Car>): List<String> {
        val maxForward = cars.maxOfOrNull { it.forward } ?: return emptyList()
        return cars.filter { it.forward == maxForward }.map { it.name }
    }
}