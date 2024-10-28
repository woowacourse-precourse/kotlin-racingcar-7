package racingcar

import kotlin.random.Random

fun main() {
    val userCarName = getCarName()
    checkCarNameCondition(userCarName)
    val userCarList = parseCar(userCarName!!)
    val trialNumber = getTrialNumber()
    val cars = userCarList.map { Car(it) }
    race(cars, trialNumber)
    val winners = findWinners(cars)
}

fun getCarName(): String? {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return readlnOrNull()
}

fun checkCarNameCondition(userCarName: String?) {
    if (userCarName.isNullOrEmpty()) {
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")
    }
}
fun parseCar(input: String): List<String> {
    val userCarList: List<String> = input.split(",")
    return userCarList
}

fun getTrialNumber(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readlnOrNull()?.toIntOrNull() ?: throw IllegalArgumentException("잘못된 값을 입력했습니다.")
}

class Car(val name: String) {
    var position = 0

    fun move() {
        if (checkForwardCondition(getRandomNumber())) {
            position++
        }
    }

    private fun getRandomNumber(): Int {
        return Random.nextInt(0, 10)
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