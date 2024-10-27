package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val cars = carNameInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    ifCarNameIsBlank(cars)

    val carList = splitCarName(cars)
    ifCarNameIsSame(carList)
    ifCarNameOverFive(carList)
    ifCarIsSingle(carList)

    val tryCount = tryCountInput("시도할 횟수는 몇 회인가요?").toInt()
    ifTryCountIsZeroOrNegative(tryCount)

    var carRacingResult = initTryCountList(carList.size)

    println("실행 결과")
    for (i in 0..<tryCount) {
        carRacingResult = randomCountToCar(carList, carRacingResult)
        printCarRacing(carList, carRacingResult)
        println()
    }

    printFinalWinner("최종 우승자 : ", findFinalWinner(carList, carRacingResult))
}

fun carNameInput(prompt: String): String {
    println(prompt)
    return readLine()
}

fun tryCountInput(promt: String): String {
    println(promt)
    return readLine()
}

fun splitCarName(carNames: String): List<String> {
    val splitedCarNames = carNames.split(",")
    return splitedCarNames
}

fun initTryCountList(carListSize: Int): MutableList<String> {
    val tryCountList = MutableList(carListSize) { "" }
    return tryCountList
}

fun randomCount(): Int {
    val randomNumber = Randoms.pickNumberInRange(0, 9)
    return randomNumber
}

fun numberIsOverFour(randomNumber: Int): Boolean {
    val bool: Boolean = (if (randomNumber >= 4) {
        true
    } else false)
    return bool
}

fun randomCountToCar(carList: List<String>, carRacingResult: MutableList<String>): MutableList<String> {
    for (i in carList.indices) {
        val randomNumber = randomCount()
        if (numberIsOverFour(randomNumber)) {
            carRacingResult[i] += "-"
        }
    }
    return carRacingResult
}

fun printCarRacing(carList: List<String>, carRacingResult: MutableList<String>) {
    for (i in carList.indices) {
        println(carList[i] + " : " + carRacingResult[i])
    }
}

fun findFinalWinner(carList: List<String>, carRacingResult: MutableList<String>): MutableList<String> {
    val winnerMove = carRacingResult.maxOf { it.length }
    val winnerIndex = mutableListOf<Int>()
    val winners = mutableListOf<String>()
    for (i in carList.indices) {
        if (carRacingResult[i].length == winnerMove) {
            winnerIndex.add(i)
        }
    }
    for (i in winnerIndex) {
        winners.add(carList[i])
    }
    return winners
}

fun printFinalWinner(promt: String, finalWinners: MutableList<String>) {
    println(promt + finalWinners.joinToString(", "))
}

fun ifCarNameIsBlank(carNames: String) {
    if (carNames.isBlank()) {
        throw IllegalArgumentException("Cars must be filled.")
    }
}

fun ifCarNameIsSame(carList: List<String>) {
    if (carList.distinct().size != carList.size) {
        throw IllegalArgumentException("Cars names must be distinct.")
    }
}

fun ifCarNameOverFive(carList: List<String>) {
    for (i in carList.indices) {
        if (carList[i].length > 5) {
            throw IllegalArgumentException("Car name's length must not over 5.")
        }
    }
}

fun ifTryCountIsZeroOrNegative(tryCount: Int) {
    if (tryCount <= 0) {
        throw IllegalArgumentException("Try Count must not be a zero or negative number.")
    }
}

fun ifCarIsSingle(carList: List<String>) {
    if (carList.size == 1) {
        throw IllegalArgumentException("Car racing starts when racers are more than two.")
    }
}