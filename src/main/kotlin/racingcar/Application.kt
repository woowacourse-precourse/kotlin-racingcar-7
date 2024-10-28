package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    try {
        val carNames = readLine()
        checkIsEmpty(carNames)
        println(carNames)
        var carList = carNames.split(",").map { Car(it.trim()) }
        checkNumberOfCarName(carList.map { it.name })
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

fun checkNumberOfCarName(list: List<String>): Boolean {
    for (name in list) {
        if (name.length > 5) throw IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.")
    }
    return true
}