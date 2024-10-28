package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    val cars = Console.readLine().split(",").map { it.trim() }
    if (cars.any { it.length > 5 }) throw IllegalArgumentException()
}
