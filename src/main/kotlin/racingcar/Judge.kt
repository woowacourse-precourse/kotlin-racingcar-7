package racingcar

class Judge {

    fun validateCarName(name: String) {
        if (name.isBlank() || name.length > 5 || name.contains(" ")) {
            throw IllegalArgumentException("경주에 등록할 자동차 이름은 공백을 포함할 수 없으며, 5자 이하여야 합니다.")
        }
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