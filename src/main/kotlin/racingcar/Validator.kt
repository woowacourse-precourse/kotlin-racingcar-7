package racingcar

class Validator {

    fun isDuplicatedCarNames(appliedCars: List<String>): Boolean {
        return appliedCars.distinct().size != appliedCars.size
    }

    fun isValidCarName(name: String): Boolean {
        return (name.isNotBlank() && name.length <= MAXIMUM_CAR_NAME_LENGTH && !name.contains(BLANK))
    }

    fun isValidRaceCount(raceCount: String): Boolean {
        return raceCount.toIntOrNull() != null && raceCount.toInt() > ZERO
    }

    fun isPossibleForward(randomValue: Int): Boolean {
        return randomValue >= STANDARD_FORWARD
    }

    companion object {
        private const val BLANK = " "
        private const val MAXIMUM_CAR_NAME_LENGTH = 5
        private const val ZERO = 0
        private const val STANDARD_FORWARD = 4
    }
}