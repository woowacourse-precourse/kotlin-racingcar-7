package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    private var cars: MutableMap<String, Car> = mutableMapOf()
    private var names: List<String> = listOf()

    fun splitToList(input: String) {
        names = input.split(",").toMutableList()
    }

    fun getNameList(): List<String> {
        return names
    }

    fun isValidName(input: String): Boolean {
        names.forEach {
            if (it.length > 5) {
                return false
            }
        }
        if (!input.contains(",")) return false
        return true
    }

    fun isValidNaturalNumber(round: String): Boolean {
        if (round.matches("\\D".toRegex())) return false
        if (round.toIntOrNull() == 0) return false
        if (round == "") return false
        return true
    }

    fun createCars() {
        names.forEach { name -> cars[name] = Car() }
    }

    fun play(key: String) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            cars[key]!!.move()
        }
    }

    fun getScore(key: String): String {
        val symbol = "-"
        val score: Int = cars[key]!!.score
        val scoreSymbol = symbol.repeat(score)
        return scoreSymbol
    }

    fun getWinner(): String {
        var topScore = -1
        var winner = ""
        for ((key, value) in cars) {
            if (value.score > topScore) {
                topScore = value.score
                winner = key
            } else if (value.score == topScore) {
                winner += ", $key"
            }
        }
        return winner
    }

}