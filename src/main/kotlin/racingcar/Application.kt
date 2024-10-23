package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun isValidName(name: String) : Boolean {
    if (name.length > 5) {
        return false
    }
    return true
}

fun isValidRound(round: Int): Boolean {
    if (round > 0) {
        return true
    }
    return false
}

fun splitName(names: String): List<String> = names.split(",").map { it }

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val inputName = Console.readLine()
    val names = splitName(inputName)
    println("시도할 횟수는 몇 회인가요?")
    val inputRound = Console.readLine()

    println("실행 결과")


    println("최종 우승자 : ")
}
