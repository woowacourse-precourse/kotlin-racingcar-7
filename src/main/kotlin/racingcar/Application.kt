package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = inputCarNames()
    println("시도할 횟수는 몇 회인가요?")
    val tryCount = inputMoveCount()

    val carPositions = initializeCarPositions(carNames)
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
