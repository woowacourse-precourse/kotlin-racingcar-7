package racingcar

import camp.nextstep.edu.missionutils.Console

class Input {
    companion object {
        private val CAR_NAME_LENGTH_RANGE = 1..5
        private val COUNT_RANGE = 0..1_000_000
        private val INPUT_EXCEPTION = IllegalArgumentException()
    }

    fun carNamesAndCount(): Pair<List<String>, Int> = carNames() to count()
    private fun carNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNames = readLine().split(",")
        if (carNames.all {
                it.length in CAR_NAME_LENGTH_RANGE &&
                        it.all { c -> c.isUpperCase() || c.isLowerCase() || c.isDigit() }
            }) {
            return carNames
        }
        throw INPUT_EXCEPTION
    }

    private fun count(): Int {
        try {
            println("시도할 횟수는 몇 회인가요?")
            val count =
                readLine().let { if (it.length <= 7 && it.toInt() in COUNT_RANGE) it.toInt() else throw INPUT_EXCEPTION }
            return count
        } catch (e: Exception) {
            throw INPUT_EXCEPTION
        }
    }

    private fun readLine() = Console.readLine() ?: throw INPUT_EXCEPTION
}

