package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    startRace()
}

fun startRace() {
    val race = inputRace()
}

fun inputRace(): Race {
    val cars = inputCarNames()
    val tryCount = inputTryCount()
    return Race(tryCount, cars)
}

private fun inputCarNames(): List<Car> {
    println(INPUT_CAR_NAMES_MESSAGE)
    return Console.readLine().split(CAR_NAME_DELIMITER).map(::Car)
}

private fun inputTryCount(): Int {
    println(INPUT_TRY_COUNT_MESSAGE)
    return try {
        Console.readLine().trim().toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(WRONG_TRY_COUNT_MESSAGE)
    }
}

private const val CAR_NAME_DELIMITER = ","
private const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
private const val INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
private const val WRONG_TRY_COUNT_MESSAGE = "시도할 횟수는 숫자여야 합니다."