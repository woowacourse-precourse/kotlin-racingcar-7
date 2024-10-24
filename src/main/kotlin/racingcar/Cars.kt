package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Cars(private val validator: Validator) {
    fun validation(names: String, iters: String): Pair<List<String>, Int> {
        val nameList = validator.splitNames(names)
        validator.nameCheck(nameList)
        val count = validator.iterCountCheck(iters)
        val validated = Pair(nameList, count)
        return validated
    }

    fun forward(validated: Pair<List<String>, Int>): ArrayList<String> {
        var forwardResult = ArrayList<String>()
        for (i in 1..validated.first.size) { // forwardResult의 크기를 차의 대수만큼 늘려주기
            forwardResult.add("")
        }
        forwardResult = singleForward(forwardResult)
        return forwardResult
    }

    private fun singleForward(forwardResult: ArrayList<String>): ArrayList<String> {
        for (i in 0..forwardResult.lastIndex) {
            if (isForward()) forwardResult[i] += "-"
        }
        return forwardResult
    }

    private fun isForward(): Boolean {
        return Randoms.pickNumberInRange(0, 9) > 3
    }
}