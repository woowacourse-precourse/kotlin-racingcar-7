package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = inputCarNames()

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = inputMoveCount()

    val carPositions = initializeCarPositions(carNames)
    println("실행 결과")
    startRacing(carPositions, tryCount)

    val winnerNames = getWinnerNames(carPositions)
    println("최종 우승자 : ${winnerNames.joinToString(", ")}")
}


private fun userInput(): String {
    val userInput = Console.readLine()
    validateNotEmpty(userInput)
    return userInput
}

private fun validateNotEmpty(input: String) {
    if (input.isBlank()) {
        throw IllegalArgumentException("입력이 비어있습니다. 유효한 값을 입력해주세요.")
    }
}


private fun inputCarNames(): List<String> {
    val userInput = userInput()
    val carNames = userInput.split(",")
    val trimmedCarNames = carNames.map { it.trim() }

    validateCarNamesNotEmpty(trimmedCarNames)
    validateCarNamesUnique(trimmedCarNames)
    validateCarNamesLength(trimmedCarNames)

    return trimmedCarNames
}

private fun validateCarNamesNotEmpty(carNames: List<String>) {
    if (carNames.any { it.isBlank() }) {
        throw IllegalArgumentException("자동차 이름은 공백일 수 없습니다. 올바른 이름을 입력해주세요.")
    }
}

private fun validateCarNamesUnique(carNames: List<String>) {
    if (carNames.size != carNames.toSet().size) {
        throw IllegalArgumentException("자동차 이름이 중복되었습니다. 각 자동차의 이름은 고유해야 합니다.")
    }
}

private fun validateCarNamesLength(carNames: List<String>) {
    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
    }
}

private fun inputMoveCount(): Int {
    val userInput = userInput()
    return validateAndParseMoveCount(userInput)
}

private fun validateAndParseMoveCount(input: String): Int {
    val moveCount = parseToInt(input)
    validateMoveCountPositive(moveCount)
    return moveCount
}

private fun parseToInt(input: String): Int {
    return try {
        input.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.")
    }
}

private fun validateMoveCountPositive(moveCount: Int) {
    if (moveCount <= 0) {
        throw IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.")
    }
}


private fun initializeCarPositions(carNames: List<String>): MutableMap<String, Int> {
    val carPositions = mutableMapOf<String, Int>()
    for (carName in carNames) {
        carPositions[carName] = 0
    }
    return carPositions
}


private fun startRacing(carPositions: MutableMap<String, Int>, tryCount: Int) {
    repeat(tryCount) {
        moveCars(carPositions)
        printCurrentPositions(carPositions)
        println()
    }
}

private fun moveCars(carPositions: MutableMap<String, Int>) {
    carPositions.keys.forEach { carName ->
        moveCar(carName, carPositions)
    }
}

private fun moveCar(carName: String, carPositions: MutableMap<String, Int>) {
    if (randomMove()) {
        carPositions[carName] = carPositions.getValue(carName) + 1
    }
}

private fun printCurrentPositions(carPositions: Map<String, Int>) {
    carPositions.forEach { (carName, position) ->
        println("$carName : ${"-".repeat(position)}")
    }
}

private fun randomMove(): Boolean {
    val randomNumber = Randoms.pickNumberInRange(0, 9)
    return randomNumber >= 4
}


private fun getWinnerNames(carPositions: Map<String, Int>): List<String> {
    val maxPosition = carPositions.values.maxOrNull() ?: 0
    return carPositions.filterValues { it == maxPosition }.keys.toList()
}






