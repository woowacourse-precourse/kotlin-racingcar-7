package racingcar

class Rules {

    fun isValidRaceCount(raceCount: String): Boolean {
        return raceCount.toIntOrNull() != null && raceCount.toInt() > 0
    }

    fun isPossibleForward(randomValue: Int): Boolean {
        return randomValue >= 4
    }
}