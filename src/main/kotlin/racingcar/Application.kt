package racingcar

import camp.nextstep.edu.missionutils.Console

var input: List<String>? = null
var num = 0
var runSizeList = mutableListOf<Int>()

fun main() {
    inputCar()
}

// 입력 받기
private fun inputCar() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    input = Console.readLine().split(",")

    println("시도할 횟수는 몇 회인가요?")
    num = Console.readLine().toInt()

    // 입력 검사하기
    if (input.isNullOrEmpty()) {
        throw IllegalArgumentException()
    }

    input!!.forEach {
        if (it.length > 5) {
            throw IllegalArgumentException("이름은 5자보다 짧게 입력해주세요")
        }
    }
    runSizeList = MutableList(input!!.size) { 0 }
}
