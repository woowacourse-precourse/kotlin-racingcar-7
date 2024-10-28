package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        val carNames = readCarNames()

    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("입력이 잘못되었습니다. 프로그램을 종료합니다.")
    }
}

private fun readCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    val names = input.split(",").map { it.trim() }

    require(names.all { it.length <= 5 }) {
        "자동차 이름은 5자 이하만 가능합니다."
    }

    return names
}
