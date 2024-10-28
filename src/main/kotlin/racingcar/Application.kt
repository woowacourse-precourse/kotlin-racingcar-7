package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carNames = getCarNames()
    val moveCount = getMoveCount()
    println("\n실행결과")
    raceCars(carNames, moveCount) // 전진 작동
}
fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine() ?: ""
    val names = input.split(",").map { it.trim() } // 이름을 쉼표로 구분하고, 양쪽 공백 제거
    return names
}

fun getMoveCount(): Int {
    println("시도할 횟수를 입력하세요.")
    val input = readLine() ?: "0"
    return input.toInt()
}

fun raceCars(carNames: List<String>, moveCount: Int) {
    val results = mutableMapOf<String, Int>()

    // 초깃값
    carNames.forEach { name ->
        results[name] = 0
    }

    // 각 이동 횟수마다 결과를 출력
    repeat(moveCount) { moveIndex ->
        for (name in carNames) {
            val randomValue = Randoms.pickNumberInRange(0, 9)
            if (randomValue >= 4) {
                results[name] = results[name]!! + 1 // 전진
            }
        }
        displayResults(results) // 이동 결과 출력
    }

    // 우승자 판별
    determineWinners(results)
}

fun displayResults(results: Map<String, Int>) {
    results.forEach { (name, distance) ->
        println("$name : ${"-".repeat(distance)}")
    }
    println() // 결과 간격 추가
}

fun determineWinners(results: Map<String, Int>) {
    val maxDistance = results.values.maxOrNull() ?: 0 // 가장 많이 전진한 거리
    val winners = results.filter { it.value == maxDistance }.keys // 우승자 필터링

    println("최종 우승자 : ${winners.joinToString(", ")}") // 우승자 출력
}
