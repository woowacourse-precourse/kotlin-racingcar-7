package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    try {
        val carNames = readLine()
        checkIsEmpty(carNames)
    } catch (e: Exception) {
        throw IllegalArgumentException(e.message)
    }

}
fun checkIsEmpty(s: String): Boolean {
    if (s.isBlank()) {
        throw IllegalArgumentException("자동차 이름을 입력해주세요.")
    }
    return true
}