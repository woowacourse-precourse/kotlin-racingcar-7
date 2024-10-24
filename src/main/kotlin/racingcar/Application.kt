package racingcar

import camp.nextstep.edu.missionutils.Console

fun inputCar(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val nameList = Console.readLine()
    val splitNameList = nameList.split(",")

    return requireNotNull(splitNameList)
}

fun inputNum(): Int{
    println("시도할 횟수는 몇 회인가요?")
    val numOfAttempts = Console.readLine().toInt()

    return requireNotNull(numOfAttempts)
}

fun main() {
    // TODO: 프로그램 구현
    val nameList = inputCar()
    val attemptNum = inputNum()
}
