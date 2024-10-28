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

fun promptForCarNames() = println(Strings.MESSAGE_INPUT_CAR_NAME)
fun promptForAttemptNumber() = println(Strings.MESSAGE_INPUT_ATTEMPT_NUMBER)

fun processCarNames(input: String): List<String> = input.split(",")
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
    println(Strings.MESSAGE_OUTPUT_RESULT)

    for (i in 0 until attemptNumber) {
        printRaceResult(carMap)
        println()
    }
}

fun printRaceResult(carMap: MutableMap<String, Int>) {
    carMap.forEach { key, value ->
        moveForwardIfValid(carMap, key, value)

        println("$key : " + "-".repeat(carMap[key]!!))
    }
}

fun moveForwardIfValid(carMap: MutableMap<String, Int>, key: String, value: Int) {
    if (isMoveForwardValid()) {
        carMap[key] = value + 1
    }
}

fun printWinners(carMap: MutableMap<String, Int>) = println(
    Strings.MESSAGE_OUTPUT_WINNER + filterWinners(carMap).joinToString(", ")
)

fun filterWinners(carMap: MutableMap<String, Int>) = carMap.filterValues { isWinnerValid(carMap, it) }.keys

fun validateCarName(carName: String) {
    require(isCarNameValidLength(carName)) { Strings.MESSAGE_EXCEPTION_CAR_NAME_LENGTH }
}