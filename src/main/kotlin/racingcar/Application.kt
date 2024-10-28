package racingcar

import kotlin.random.Random

fun main() {
    val userCarName = getCarName()
    checkCarNameCondition(userCarName)
    val userCarList = parseCar(userCarName!!)
    val trialNumber = getTrialNumber()
    val randomNumber = getRandomNumber()
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

fun getRandomNumber(): Int {
    return Random.nextInt(0, 10)
}