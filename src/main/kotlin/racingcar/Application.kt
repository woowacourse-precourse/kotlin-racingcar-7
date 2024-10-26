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
        move(distance)
    }

}

private fun move (moveDistance: MutableList<Int>) {
    moveDistance.indices.forEach { i ->
        if (Randoms.pickNumberInRange(0 ,9) >= 4) {
            moveDistance[i]++
        }
    }
}
