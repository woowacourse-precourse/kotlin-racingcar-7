package racingcar

import camp.nextstep.edu.missionutils.Console
fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val carNames = Console.readLine().split(",") ?: emptyList()

    println("시도할 횟수는 몇 회인가요?")
    val times = readln().toInt() ?: 0
}
