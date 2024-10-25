package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val cars = Console.readLine().split(",").map { it.trim() }
    if (cars.any { it.length > 5 }) throw IllegalArgumentException()
}
