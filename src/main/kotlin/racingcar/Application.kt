package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val inputName: List<String>
    val movingNumber: Int
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    try {
        inputName = readLine().split(",").map { it.trim() }
        require(inputName.all { it.length <= 5 }) { "자동차 이름은 5자 이하여야 합니다." }
    } catch (e: Exception) {
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")
    }

    println("시도할 횟수는 몇 회인가요?")

    try {
        movingNumber = readLine().toInt()
        require(movingNumber > 0) { "시도 횟수는 1 이상이어야 합니다." }
    } catch (e: Exception) {
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")
    }

    // 주어진 횟수 n대의 자동차는 전진 또는 멈춤
    val carCount = inputName.count()

    val location: MutableList<String?> = MutableList(carCount) {""}
    println("실행 결과")
    // 조건문으로 0 ~ 9 사이의 무작위 값을 구해서 4이상인 경우 전진 나머진 멈춤
    for (i in 0 until movingNumber) {
        move(inputName, location)
        for (j in 0 until carCount) {
            println("${inputName[j]} : ${location[j]}")
        }
        println()
    }
    val winners = win(inputName, location)
    println("최종 우승자 : ${winners.joinToString(", ")}")
}

fun move(inputName: List<String>, location: MutableList<String?>): MutableList<String?> {
    val carCount = inputName.count()
    for (i in 0 until carCount) {
        val randomNumber = MutableList(carCount) { Randoms.pickNumberInRange(0, 9) }
        if (randomNumber[i] >= 4) {
            location[i] += "-"
        }
    }

    return location
}

fun win(inputName: List<String>, location: MutableList<String?>): List<String> {
    val carCount = inputName.count()
    val winners = mutableListOf<String>()
    val result = location.filterNotNull().maxOrNull()
    for (i in 0 until carCount) {
        if (location[i] == result) {

            winners += inputName[i]
        }
    }
    return winners
}