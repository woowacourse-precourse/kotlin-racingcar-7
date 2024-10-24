package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun lenCheck(nameList: List<String>): Boolean {
    nameList.forEach {
        if (it.length > 6)
            return false
    }
    return true
}

fun inputCar(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val nameList = Console.readLine()
    val splitNameList = nameList.split(",")
    if (lenCheck(splitNameList)){
        return requireNotNull(splitNameList)
    } else
        throw IllegalArgumentException()
}

fun inputNum(): Int{
    println("시도할 횟수는 몇 회인가요?")
    val numOfAttempts = Console.readLine().toInt()

    return requireNotNull(numOfAttempts)
}

fun movementDecision(): Boolean {
    if (Randoms.pickNumberInRange(0, 9) >= 4)
        return true
    return false
}

fun main() {
    // TODO: 프로그램 구현
    val nameList = inputCar()
    val attemptNum = inputNum()
}
