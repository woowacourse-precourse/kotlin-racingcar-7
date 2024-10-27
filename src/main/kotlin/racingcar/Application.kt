package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    fun splitNamesByDelimiter(input: String): List<String> {
        return input.split(",")
    }

    fun validateNameNotNull(cars: List<String>) {
        cars.forEach {
            if (it.isEmpty()) throw IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.")
        }
    }

    fun validateNameLength(cars: List<String>) {
        cars.forEach {
            if (it.length > 5) throw IllegalArgumentException("자동차의 이름은 최대 5자입니다.")
        }
    }

    fun validateNameUniqueness(cars: List<String>) {
        if (setOf(cars).size < cars.size) throw IllegalArgumentException("중복된 자동차 이름이 있습니다.")
    }

    fun readCarNames() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = splitNamesByDelimiter(Console.readLine())
        validateNameNotNull(input)
        validateNameLength(input)
        validateNameUniqueness(input)
    }

    fun readTrialCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine().toInt()
    }

    println(readCarNames())
    println(readTrialCount())
}
