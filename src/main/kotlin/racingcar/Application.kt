package racingcar

import kotlin.random.Random

fun main() {
    val userCarName = getCarName()
    val userCarList = parseCar(userCarName!!)
    val trialNumber = getTrialNumber()
    val randomNumber = getRandomNumber()
}

fun getCarName(): String? {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return readlnOrNull()
}

fun parseCar(input: String): List<String> {
    val userCarList: List<String> = input.split(",")
    return userCarList
}

fun getTrialNumber(): Int? {
    println("시도할 횟수는 몇 회인가요?")
    return readlnOrNull()?.toIntOrNull()
}

fun getRandomNumber(): Int {
    return Random.nextInt(0, 10)
}