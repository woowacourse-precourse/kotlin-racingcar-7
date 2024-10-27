package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    // n대의 자동차 이름 입력
    val input = Console.readLine().trim()
    // 쉼표로 구분
    val nameList = input.split(",")

    // n은 2~16사이
    if (nameList.size !in 2..16) throw IllegalArgumentException("최소 2개에서 최대 16개의 이름을 입력해주세요.")

    // 5글자로 제한
    for (name in nameList) {
        if (name.length !in 1..5) throw IllegalArgumentException("이름은 최소 한글자에서 최대 5글자로 입력해주세요.")
    }

    // 중복 이름 구분
    val names = nameList
        .groupingBy { it }
        .eachCount()
        .flatMap { (key, count) ->
            if (count > 1) {
                List(count) { i -> "${key}_$i" }
            } else {
                listOf(key)
            }
        }
        .joinToString(",")

    println("시도할 횟수는 몇 회인가요?")
    val stingTypeTryCountInput = Console.readLine().trim()

    // 정수가 아닌 입력에 대한 오류처리
    val test = stingTypeTryCountInput.toIntOrNull() == null
    if (test) throw IllegalArgumentException("시도할 횟수는 정수를 입력해주세요.")

    // 횟수 제한 범위가 넘어가는 오류
    val tryCountInput = stingTypeTryCountInput.toInt()
    val countRange = tryCountInput in 1..15
    if (!countRange) throw IllegalArgumentException("시도할 횟수는 최소 1에서 16의 자연수로 입력해주세요.")

    println(names)
    println("$tryCountInput")
}
