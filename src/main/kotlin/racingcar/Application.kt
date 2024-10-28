package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    val carInput = getInputCarList()
    val gameCount = getInputGameCount()
    RacingGame(carList = carInput, totalRound = gameCount).play()
}

private const val INPUT_PLAY_CAR_STR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
fun getInputCarList(): String {
    println(INPUT_PLAY_CAR_STR)
    val input = Console.readLine()
    Console.close()
    return input
}

private const val INPUT_GAME_COUNT_STR = "시도할 횟수는 몇 회인가요?"
fun getInputGameCount(): Int {
    println(INPUT_PLAY_CAR_STR)
    val input = Console.readLine()
    Console.close()
    return input.toGameCount()
}

private fun String.toGameCount(): Int {
    return trim().toInt()
}
