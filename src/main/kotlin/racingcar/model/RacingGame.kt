package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    private var cars: MutableMap<String, Car> = mutableMapOf()
    var names: List<String> = listOf()

    fun setInput(input: String) {
        splitToList(input)
    }

    fun splitToList(input: String) {
        names = input.split(",").toMutableList()
    }

    fun getNameList(): List<String> {
        return names
    }

    fun isValidName(): Boolean {
        names.forEach {
            if (it.length > 5) {
                return false
            }
        }
        return true
    }

    fun isValidNaturalNumber(round: String): Boolean {
        if (round.matches("\\D".toRegex())) return false
        if (round.toInt() == 0) return false
        return true
    }

    fun createCars() {
        names.forEach { name -> cars[name] = Car() }
    }

    fun play(key: String) {
        cars[key]!!.move(Randoms.pickNumberInRange(0, 9))
    }

    fun getScore(key: String): String {
        val symbol = "-"
        var score: Int = cars[key]!!.score
        val scoreSymbol = symbol.repeat(score)
        return scoreSymbol
    }

    fun getWinner(): String {
        var topScore = 0
        var winner = ""
        names.forEach {
            val score = cars[it]!!.score
            if (score > topScore) {
                topScore = score
                winner = it
            }
        }
        return winner
    }

}