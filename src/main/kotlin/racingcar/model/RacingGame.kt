package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    private var cars: MutableMap<String, Car> = mutableMapOf()

    fun splitToList(input: String): List<String> {
        return input.split(",").toMutableList()
    }

    fun isValidName(nameList: List<String>): Boolean {
        return when {
            nameList.any { it.length > 5 } -> false
            nameList.size != nameList.distinct().size -> false
            else -> true
        }
    }

    fun isNaturalNumber(roundString: String): Boolean {
        val round = roundString.toIntOrNull() ?: 0
        return round > 0
    }

    fun createCars(names: List<String>): Map<String, Car> {
        names.forEach { cars[it] = Car() }
        return cars
    }

    fun play(key: String) {
        val randomValue = Randoms.pickNumberInRange(0, 9)
        if (randomValue >= 4) {
            cars[key]!!.move()
            cars[key]!!.updateScoreSymbol()
        }
    }

    fun getWinner(): String {
        val winnerList = mutableListOf<String>()
        val maxScore = cars.maxOf { it.value.score }
        cars.forEach {
            if (it.value.score == maxScore) {
                winnerList.add(it.key)
            }
        }
        return winnerList.joinToString(", ")
    }

}