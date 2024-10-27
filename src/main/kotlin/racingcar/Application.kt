package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carNames = inputCarNames()
    val times = inputTimes()

    val distance = MutableList(carNames.size) { 0 }

    repeat(times) {
        racingRound(carNames, distance)
    }

    printWinner(carNames,distance)

    Console.close()
}

private fun printWinner(carNames: List<String>, moveDistance: List<Int>) {
    val winners = mutableListOf<String>()
    var maxDistance = moveDistance.maxOrNull()

    moveDistance.forEachIndexed { index, distance ->
        if (distance == maxDistance) {
            winners.add(carNames[index])
        }
    }
    println("최종 우승자 : ${winners.joinToString(", ")}")
}

private fun inputTimes() : Int {
    println("시도할 횟수는 몇 회인가요?")
    val input = Console.readLine().toInt()
    return input
}

private fun inputCarNames() : List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = Console.readLine().split(",").map { it.trim() }
    carNames.forEach {
        if (it.length > 5) throw IllegalArgumentException("자동차 이름은 5글자만 입력 가능합니다.")
    }
    return carNames
}


private fun racingRound(carNames: List<String>, moveDistance: MutableList<Int>) {
    isItMove(moveDistance)
    printRacing(carNames, moveDistance)
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
