package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

val isCarNameValidLength = { carName: String -> carName.length <= 5 }

fun main() {
    val carMap = mutableMapOf<String, Int>()

    promptForCarNames()
    initializeCarMap(carMap, processCarNames(readLine()))

    promptForAttemptNumber()
    val attemptNumber = readLine().toInt() // TODO : 위치 변경?

    println("실행 결과")
    for (i in 0 until attemptNumber) {
        carMap.forEach { key, value ->
            if (pickNumberInRange(0, 9) >= 4) {
                carMap[key] = value + 1
            }

            println("$key : " + "-".repeat(carMap[key]!!))
        }
        println(carMap)  // TODO : 테스트용 출력 ; 삭제할 것
        println()
    }

    // TODO: 함수 분리할 것
    println(
        "최종 우승자 : " + carMap.filterValues { it == carMap.values.maxOrNull() }
            .keys
            .joinToString(", ")
    )
}

fun promptForCarNames() = println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
fun promptForAttemptNumber() = println("시도할 횟수는 몇 회인가요?")

fun processCarNames(input: String) = input.split(",")
    .map { it.trim() }

fun initializeCarMap(carMap: MutableMap<String, Int>, carList: List<String>) {
    for (carName in carList) {
        validateCarName(carName)
        carMap.put(carName, 0)
    }
}

fun validateCarName(carName: String) {
    require(isCarNameValidLength(carName)) { "자동차 이름은 5자 이하만 가능하다." }
}