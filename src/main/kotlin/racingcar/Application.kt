package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val cars = Console.readLine().split(",").map { it.trim() }
    if (cars.any { it.length > 5 }) throw IllegalArgumentException()

    val times: Int
    try {
        times = Console.readLine().toInt()
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }
}

fun canMove(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
