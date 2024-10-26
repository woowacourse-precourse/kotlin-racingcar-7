package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Model(private val validator: Validator) {
    fun validation(names: String, iterationCount: String): Pair<MutableMap<String, Int>, Int> {
        val splitNames = validator.splitNames(names)
        validator.nameCheck(splitNames)
        val countNumber = validator.iterationCountCheck(iterationCount)
        val result = mutableMapOf<String, Int>()
        for (i in 0..splitNames.lastIndex) {
            result[splitNames[i]] = 0
        }
        val validated = Pair(result, countNumber)
        return validated
    }

    fun forward(validated: Pair<MutableMap<String, Int>, Int>): MutableList<MutableMap<String, Int>> {
        var result: MutableMap<String, Int>
        val roundResults = mutableListOf<MutableMap<String, Int>>()
        for (i in 1..validated.second) {
            result = singleRound(validated.first)
            roundResults.add(result)
        }
        return roundResults
    }

    private fun singleRound(result: MutableMap<String, Int>): MutableMap<String, Int> {
        result.forEach { (key, value) ->
            result.replace(key, isForward(value))
        }
        return result
    }

    private fun isForward(distance: Int): Int {
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            return distance + 1
        }
        return distance
    }

    fun findWinner(result: MutableMap<String, Int>): MutableList<String> {
        val winners = mutableListOf<String>()
        val sorted = result.toList().sortedByDescending {
            it.second
        }
        val max = sorted[0].second
        var index = 0
        while (index < sorted.size && compareValues(max, sorted[index].second)) {
            winners.add(sorted[index].first)
            index++
        }
        return winners
    }

    private fun compareValues(max: Int, value: Int): Boolean {
        return max == value
    }
}