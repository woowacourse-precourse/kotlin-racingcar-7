package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import kotlin.collections.set

val isCarNameValidLength = { carName: String -> carName.length <= 5 }
val isMoveForwardValid = { pickNumberInRange(0, 9) >= 4 }
val isWinnerValid = { carMap: MutableMap<String, Int>, count: Int -> count == carMap.values.maxOrNull() }

fun main() {

    promptForCarNames()
    val carList = processCarNames(readLine())
    val carMap = initializeCarMap(carList)

    promptForAttemptNumber()
    val attemptNumber = processAttemptNumber(readLine())

    printAllRaceResults(carMap, attemptNumber)

    printWinners(carMap)
}

fun promptForCarNames() = println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
fun promptForAttemptNumber() = println("시도할 횟수는 몇 회인가요?")

fun processCarNames(input: String) = input.split(",")
    .map { it.trim() }

fun processAttemptNumber(input: String) = input.toInt()

fun initializeCarMap(carList: List<String>): MutableMap<String, Int> {
    val carMap = mutableMapOf<String, Int>()

    for (carName in carList) {
        validateCarName(carName)
        carMap.put(carName, 0)
    }

    return carMap
}

fun printAllRaceResults(carMap: MutableMap<String, Int>, attemptNumber: Int) {
    println("실행 결과")

    for (i in 0 until attemptNumber) {
        printRaceResult(carMap)
        println()
    }
}

fun printRaceResult(carMap: MutableMap<String, Int>) {
    carMap.forEach { key, value ->
        moveForwardIfVaild(carMap, key, value)

        println("$key : " + "-".repeat(carMap[key]!!))
    }
}

fun moveForwardIfVaild(carMap: MutableMap<String, Int>, key: String, value: Int) {
    if (isMoveForwardValid()) {
        carMap[key] = value + 1
    }
}

fun printWinners(carMap: MutableMap<String, Int>) = println(
    "최종 우승자 : " + filterWinners(carMap).joinToString(", ")
)

fun filterWinners(carMap: MutableMap<String, Int>) = carMap.filterValues { isWinnerValid(carMap, it) }.keys

fun validateCarName(carName: String) {
    require(isCarNameValidLength(carName)) { "자동차 이름은 5자 이하만 가능하다." }
}