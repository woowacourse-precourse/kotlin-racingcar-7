package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = getCarNames()
    println("시도할 횟수는 몇 회인가요?")
    val times = getTimes()

    println()

    val race = createEmptyStringList(cars.size)
    printGameStatus(times, cars, race)

    println("최종 우승자 : " + getWinners(cars, race).joinToString(", "))
}

fun getCarNames(): List<String> {
    val cars = Console.readLine().split(",")
    cars.forEach { checkCarNames(it) }
    return cars
}

fun checkCarNames(carName: String) {
    if (carName.count() > 5) {
        throw IllegalArgumentException("잘못된 입력입니다. (자동차의 이름은 5자 이하여야 합니다.)")
    }
}

fun getTimes(): Int {
    val times = Console.readLine()
    return checkTimes(times)
}

fun checkTimes(times: String): Int {
    try {
        return times.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("잘못된 입력입니다. (횟수는 정수로만 입력되어야 합니다.)")
    }
}

fun createEmptyStringList(size: Int): ArrayList<String> {
    val list = ArrayList<String>()
    for (i in 0 until size) {
        list.add("")
    }
    return list
}

fun printGameStatus(times: Int, cars: List<String>, race: ArrayList<String>) {
    println("실행 결과")
    for (i in 0 until times) {
        for (j in cars.indices) {
            race[j] += moveOrStop()
            println(cars[j] + " : " + race[j])
        }
        println()
    }
}

fun moveOrStop(): String {
    return if (Randoms.pickNumberInRange(0, 9) >= 4) {
        "-"
    } else {
        ""
    }
}

fun getWinners(cars: List<String>, race: ArrayList<String>): ArrayList<String> {
    val gameResult = race.max()
    val winners = ArrayList<String>()
    for (i in race.indices) {
        if (race[i] == gameResult) {
            winners.add(cars[i])
        }
    }
    return winners
}