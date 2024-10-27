package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    val carMap = mutableMapOf<String, Int>()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    // TODO : trim() ? 으로 공백 제거? // 커밋 body에 올렸다 PR 설명에 적기
    for (i in readLine().split(",")) {
        carMap.put(i, 0)
    }

    println("시도할 횟수는 몇 회인가요?")
    val attemptNumber = readLine().toInt() // TODO : 위치 변경?

    println("실행 결과")
    for (i in 0 until attemptNumber) {
        carMap.forEach { key, value ->
            if (pickNumberInRange(0,9) >= 4) {
                carMap[key] = value + 1
            }

            println("$key : " + "-".repeat(carMap[key]!!))
        }
        println()
    }
}
