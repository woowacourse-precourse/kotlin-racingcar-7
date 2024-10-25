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

    val movement = mutableMapOf<String, StringBuilder>()
    repeat(times) {
        cars.forEach { car ->
            movement[car] = (movement[car] ?: StringBuilder()).apply {
                if (canMove()) append("-")
            }
        }
        printResult(cars, movement)
    }
    print(getWinner(movement))
}

fun canMove(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4

fun printResult(cars: List<String>, movement: Map<String, StringBuilder>) {
    cars.forEach { car ->
        println("$car : ${movement[car] ?: ""}")
    }
    println()
}

fun getWinner(movement: Map<String, StringBuilder>): String {
    val maxMove = movement.maxOf { it.value.length }
    val winner = movement.filter { it.value.length == maxMove }
    return winner.keys.joinToString()
}