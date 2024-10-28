package racingcar

import kotlin.random.Random

fun main() {
    val userCarName = getCarName()
    val userCarList = parseCar(userCarName!!)
    val trialNumber = getTrialNumber()
    val cars = userCarList.map { Car(it) }
    race(cars, trialNumber)
    val winners = findWinners(cars)
    printWinners(winners)
}

fun getCarName(): String? {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return readlnOrNull()
}

fun parseCar(input: String): List<String> {
    val userCarList: List<String> = input.split(",").map { it.trim() }
    userCarList.forEach {
        if (it.isNullOrEmpty()) {
            throw IllegalArgumentException("자동차 이름을 입력하지 않았습니다.")
        }
        else if (it.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
    }
    return userCarList
}

fun getTrialNumber(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readlnOrNull()?.toIntOrNull() ?: throw IllegalArgumentException("시도할 횟수를 잘못 입력했습니다.")
}

class Car(val name: String) {
    var position = 0

    fun move() {
        if (checkForwardCondition(getRandomNumber())) {
            position++
        }
    }

    private fun getRandomNumber(): Int {
        val randomNumber = Random.nextInt(0, 10)
        println(randomNumber)
        return randomNumber
    }

    private fun checkForwardCondition(randomNumber: Int): Boolean {
        return randomNumber >= 4
    }
}

fun race(cars: List<Car>, trialNumber: Int) {
    println()
    println("실행 결과")
    for (i in 1..trialNumber) {
        cars.forEach { car ->
            car.move()
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }
}

fun findWinners(cars: List<Car>): List<String> {
    val maxPosition = cars.maxOf { it.position }
    return cars.filter { it.position == maxPosition }.map { it.name }
}

fun printWinners(winners: List<String>) {
    println("최종 우승자 : ${winners.joinToString(", ")}")
}