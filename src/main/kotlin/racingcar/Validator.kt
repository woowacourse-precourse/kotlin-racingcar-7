package racingcar

class Validator {

    fun isDuplicatedCarNames(appliedCars: List<String>): Boolean {
        return appliedCars.distinct().size != appliedCars.size
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
}