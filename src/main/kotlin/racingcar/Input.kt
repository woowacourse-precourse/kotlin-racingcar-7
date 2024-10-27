package racingcar

import camp.nextstep.edu.missionutils.Console

class Input {
    companion object {
        private val COUNT_RANGE = 0..1_000_000
        private val INPUT_EXCEPTION = IllegalArgumentException()
    }

    fun carNamesAndCount(): Pair<List<String>, Int> = carNames() to count()
    private fun carNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return readLine().split(",").let { if (it.all(RacingCar::checkCarName)) it else throw INPUT_EXCEPTION }
    }

    private fun count(): Int {
        try {
            println("시도할 횟수는 몇 회인가요?")
            val input = readLine()
            require(input.length <= COUNT_RANGE.last.toString().length && input.toInt() in COUNT_RANGE)
            return input.toInt()
        } catch (e: Exception) {
            throw INPUT_EXCEPTION
        }
    }

    private fun readLine() = Console.readLine() ?: throw INPUT_EXCEPTION
}

