package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

fun main() {
    val cars = Console.readLine().split(",").map { Car(it.trim(), StringBuilder()) }
    if (cars.any { it.name.length > 5 }) throw IllegalArgumentException()

    val times: Int
    try {
        times = Console.readLine().toInt()
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }

    repeat(times) {
        cars.forEach { car ->
            if (canMove()) {
                car.move.append("-")
            }
        }
        printResult(cars)
    }
    print(getWinner(cars))
}

fun canMove(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4

fun printResult(cars: List<Car>) {
    cars.forEach { car ->
        println("${car.name} : ${car.move}")
    }
    println()
}

fun getWinner(car: List<Car>): String {
    val maxMove = car.maxOf { it.move.length }
    val winner = car.filter { it.move.length == maxMove }.map { it.name }
    return winner.joinToString()
}