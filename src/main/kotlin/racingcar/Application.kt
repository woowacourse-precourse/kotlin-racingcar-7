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
    return userInput
}

private fun inputCarNames(): List<String> {
    val userInput = userInput()
    val carNames = userInput.split(",")
    val trimmedCarNames = carNames.map { it.trim() }
    return trimmedCarNames
}

private fun inputMoveCount(): Int {
    val userInput = userInput()
    val moveCount = userInput.toInt()
    return moveCount
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
