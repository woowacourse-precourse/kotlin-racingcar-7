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
    val maxDistance = moveDistance.maxOrNull()

    moveDistance.forEachIndexed { index, distance ->
        if (distance == maxDistance) {
            winners.add(carNames[index])
        }
    }
    println("최종 우승자 : ${winners.joinToString(", ")}")
}

private fun inputTimes() : Int {
    println("시도할 횟수는 몇 회인가요?")
    val input = Console.readLine()

    if (input.isNullOrBlank()) throw IllegalArgumentException("횟수를 입력해 주세요")

    val times = input.toIntOrNull() ?: throw IllegalArgumentException("올바른 숫자를 입력해 주세요.")

    if (times < 1) throw IllegalArgumentException("올바른 숫자를 입력해 주세요.")

    return times
}

private fun inputCarNames() : List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val carNames = Console.readLine().split(",").map { it.trim() }

    carNames.forEach { name ->
        when {
            name.isBlank() -> throw IllegalArgumentException("올바른 자동차 이름을 입력해 주세요.")
            name.length > 5 -> throw IllegalArgumentException("자동차 이름은 5글자 이하로 설정해주세요.")
            name.contains(Regex("[^가-힣a-zA-Z]")) -> throw IllegalArgumentException("올바른 자동차 이름을 사용해주세요.")
        }
    }

    if (carNames.size != carNames.toSet().size) {
        throw IllegalArgumentException("중복된 이름은 사용할 수 없습니다.")
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
