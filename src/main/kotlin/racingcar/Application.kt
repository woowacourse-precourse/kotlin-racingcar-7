package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    try {
        val carNames = readLine()
        checkIsEmpty(carNames)
        println(carNames)
        var carList = carNames.split(",").map { Car(it.trim()) }
        checkNumberOfCarName(carList.map { it.name })
        checkDuplicationName(carList.map { it.name })

        println("시도할 횟수는 몇 회인가요?")
        val count = readLine()
        checkRacingCount(count)
        startGame(count.toInt(), carList)
    } catch (e: Exception) {
        throw IllegalArgumentException(e.message)
    }

}
fun checkIsEmpty(s: String): Boolean {
    if (s.isBlank()) {
        throw IllegalArgumentException("자동차 이름을 입력해주세요.")
    }
    return true
}

fun checkNumberOfCarName(list: List<String>): Boolean {
    for (name in list) {
        if (name.length > 5) throw IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.")
    }
    return true
}

fun checkRacingCount(s: String): Boolean {
    if (s.isBlank()) {
        throw IllegalArgumentException("횟수를 입력해주세요.")
    } else if (s.toIntOrNull() == null || s.toDoubleOrNull() == null) {
        throw IllegalArgumentException("숫자만 입력해주세요.")
    }
    return true
}

fun checkDuplicationName(list: List<String>): Boolean {
    if (list.size != list.distinct().size) {
        throw IllegalArgumentException("중복된 이름의 자동차가 존재합니다.")
    }
    return true
}

fun startGame(count: Int, carList: List<Car>) {
    println("실행 결과")
    repeat(count) {
        increaseDistance(carList)
        printCurrentDistance(carList)
    }
    printWinnerCarName(carList)
}

fun getRandomNumber(min: Int, max: Int): Int =
    camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(min, max)

fun increaseDistance(list: List<Car>) =
    list.map { car ->
        val randomN = getRandomNumber(0, 9)
        if (randomN >= 4) car.increaseDistance(1)
        else car
    }

fun printCurrentDistance(list: List<Car>) {
    for (car in list) {
        println(car)
    }
    println()
}

fun getWinner(list: List<Car>): List<Car> {
    val maxDistance = list.maxOf { it.distance }
    return list.filter { it.distance == maxDistance }
}

fun printWinnerCarName(list: List<Car>) {
    val winner = getWinner(list)
    print("최종 우승자 : ")
    for ((index, car) in winner.withIndex()) {
        print(car.name)
        if (index != winner.lastIndex) print(", ")
    }
}