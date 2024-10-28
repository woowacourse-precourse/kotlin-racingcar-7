package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    startRace()
}

fun startRace() {
    val race = inputRace()
    val raceAllProgress = race.run()
    val winners = race.getWinners()
    displayRaceResult(raceAllProgress, winners)
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

private fun displayRaceResult(raceAllProgress: List<List<Car>>, winners: List<Car>) {
    println(PRINT_RUN_RESULT_MESSAGE)
    displayRaceAllProgress(raceAllProgress)
    displayRaceWinner(winners)
}

fun displayRaceWinner(winners: List<Car>) {
    val winnersSentences = winners.joinToString(", ") { it.name }
    println(PRINT_RACE_WINNER_MESSAGE.format(winnersSentences))
}

fun displayRaceAllProgress(raceAllProgress: List<List<Car>>) {
    raceAllProgress.forEach { progress ->
        displayRaceEachProgress(progress)
    }
}

fun displayRaceEachProgress(progress: List<Car>) {
    progress.forEach { car ->
        println(PRINT_RACE_STATE_FORMAT.format(car.name, car.goState))
    }
    println()
}

private const val CAR_NAME_DELIMITER = ","
private const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
private const val INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
private const val WRONG_TRY_COUNT_MESSAGE = "시도할 횟수는 숫자여야 합니다."
private const val PRINT_RUN_RESULT_MESSAGE = "실행 결과"
private const val PRINT_RACE_WINNER_MESSAGE = "최종 우승자 : %s"
private const val PRINT_RACE_STATE_FORMAT = "%s : %s"