package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val carNames = Console.readLine().split(",") ?: emptyList()

    println("시도할 횟수는 몇 회인가요?")

    val times = readln().toInt() ?: 0
    val distance = MutableList(carNames.size) { 0 }

    repeat(times) {
        isItMove(distance)
        printRacing(carNames,distance)
    }

}

private fun isItMove (moveDistance: MutableList<Int>) {
    moveDistance.indices.forEach { i ->
        if (Randoms.pickNumberInRange(0 ,9) >= 4) {
            moveDistance[i]++
        }
    }
}

private fun printRacing(carNames: List<String>, moveDistance: List<Int>) {
    carNames.forEachIndexed { i, name ->
        println("$name : ${"-".repeat(moveDistance[i])}")
    }
    println()
}
