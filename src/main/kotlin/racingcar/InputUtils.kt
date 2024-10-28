package racingcar

import camp.nextstep.edu.missionutils.Console

fun inputCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    return input.split(",").map { it.trim() }
}

fun inputAttemptCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return Console.readLine().toInt()
}

fun validateCarNames(carNames: List<String>) {
    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.")
    }
}
