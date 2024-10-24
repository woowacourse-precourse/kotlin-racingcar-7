package racingcar

class Judge {

    fun isDuplicatedCarNames(appliedCars: List<String>): Boolean {
        return appliedCars.distinct().count() != appliedCars.count()
    }

    fun isValidCarName(name: String): Boolean {
        return (name.isNotBlank() && name.length <= 5 && !name.contains(" "))
    }

    fun isValidRaceCount(raceCount: String): Boolean {
        return raceCount.toIntOrNull() != null && raceCount.toInt() > 0
    }

    fun isPossibleForward(randomValue: Int): Boolean {
        return randomValue >= 4
    }

    fun findWinnerName(cars: List<Car>): List<String> {
        val maxForward = cars.maxOfOrNull { it.forward } ?: return emptyList()
        return cars.filter { it.forward == maxForward }.map { it.name }
    }
}