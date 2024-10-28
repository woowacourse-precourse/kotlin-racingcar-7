package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
}

class InputProcessor {
    fun inputCarNames(): List<String> {
        println("자동차 이름을 쉼표(,)로 구분하여 입력하시오.")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }
        require(carNames.all { it.length <= 5 }) { "자동차 이름은 5자 이하가 가능함." }
        return carNames
    }

    fun inputAttemptCount(): Int {
        println("시도할 횟수를 입력하시오.")
        val input = Console.readLine()
        val count = input.toIntOrNull() ?: throw IllegalArgumentException("시도 횟수는 양의 정수여야 함.")
        require(count > 0) { "시도 횟수는 양의 정수여야 함." }
        return count
    }
}

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move() {
        position++
    }
}

