package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Cars(private val validator: Validator) {
    fun validation(nameString: String, iterString: String): Pair<MutableMap<String, Int>, Int> {
        val nameList = validator.splitNames(nameString)
        validator.nameCheck(nameList)
        val count = validator.iterCountCheck(iterString)
        val resultMap = mutableMapOf<String, Int>()
        for (i in 0..nameList.lastIndex) {
            resultMap[nameList[i]] = 0
        }
        val validated = Pair<MutableMap<String, Int>, Int>(resultMap, count)
        return validated
    }

    fun forward(resultMap: MutableMap<String, Int>, count: Int): MutableMap<String, Int> {
        resultMap.forEach { (key, value) ->
            resultMap.replace(key, isForward(value))
        }
        return resultMap
    }

    private fun isForward(distance: Int): Int {
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            return distance + 1
        }
        return distance
    }
}