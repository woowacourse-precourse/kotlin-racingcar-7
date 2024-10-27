package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    // n대의 자동차 이름 입력
    val input = Console.readLine().trim()
    // 쉼표로 구분
    var nameList = input.split(",")

    // n은 2~16사이
    if (nameList.size !in 2..16) throw IllegalArgumentException("최소 2개에서 최대 16개의 이름을 입력해주세요.")

    // 5글자로 제한
    for (name in nameList) {
        if (name.length !in 1..5) throw IllegalArgumentException("이름은 최소 한글자에서 최대 5글자로 입력해주세요.")
    }

    // 중복 이름 구분
    nameList = nameList
        .groupingBy { it }
        .eachCount()
        .flatMap { (key, count) ->
            if (count > 1) {
                List(count) { i -> "${key}_$i" }
            } else {
                listOf(key)
            }
        }

    // 시도 횟수 입력
    println("시도할 횟수는 몇 회인가요?")
    val stingTypeTryCountInput = Console.readLine().trim()

    // 정수가 아닌 입력에 대한 오류처리
    val test = stingTypeTryCountInput.toIntOrNull() == null
    if (test) throw IllegalArgumentException("시도할 횟수는 정수를 입력해주세요.")

    // 횟수 제한 범위가 넘어가는 오류
    val tryCountInput = stingTypeTryCountInput.toInt()
    val countRange = tryCountInput in 1..15
    if (!countRange) throw IllegalArgumentException("시도할 횟수는 최소 1에서 16의 자연수로 입력해주세요.")

    // 실행 결과 출력
    println("\n실행 결과")

    // 이름과 현재 위치 매핑
    var carWithCount = nameList
        .groupBy { it }
        .map { (carName, _) -> carName to 0 }

    // 레이싱 시작
    repeat(tryCountInput) {
        // 난수조건에 따라 위치 변경
        carWithCount = carWithCount.map { (carName, carLocation) ->
            val isGoOneStep = Randoms.pickNumberInRange(0, 9) >= 4
            if (isGoOneStep) carName to carLocation + 1 else carName to carLocation
        }

        // 각 라운드 결과 출력
        for (car in carWithCount) {
            val result = "-".repeat(car.second)
            println("${car.first} : $result")
        }

        println()
    }

    // 최종 우승자 산출
    val maxCount = carWithCount.maxOf { it.second }
    val winners = carWithCount.filter { it.second == maxCount }.joinToString(", ") { it.first }

    // 우승자 출력
    println("최종 우승자 : $winners")
}
