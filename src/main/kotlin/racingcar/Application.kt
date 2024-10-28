package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = inputCarNames()
    println("시도할 횟수는 몇 회인가요?")
    val moveCount = inputMoveCount()
}


private fun userInput(): String {
    val userInput = Console.readLine()
    return userInput
}

private fun inputCarNames(): List<String> {
    val userInput = userInput()
    val carNames = userInput.split(",")
    return carNames
}

private fun inputMoveCount(): Int {
    val userInput = userInput()
    val moveCount = userInput.toInt()
    return moveCount
}