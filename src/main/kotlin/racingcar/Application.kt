package racingcar

import camp.nextstep.edu.missionutils.Console

fun checkRacerName(name: String): Pair<Boolean, List<String>> {
    val racerNames = name.split(",")

    if (racerNames.size <= 1) {
        throw IllegalArgumentException("레이서는 최소 2명 이어야 합니다.")
    }
    if (racerNames.any { it.length >= 6 }) {
        throw IllegalArgumentException("레이서의 이름은 5자 이하 이어야 합니다.")
    }
    return Pair(true, racerNames)
}

fun checkRaceAttempts(attempts: String): Int {
    val attemptCount = try {
        attempts.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("시도 횟수는 숫자 여야 합니다.")
    }
    return attemptCount
}

fun main() {
    // TODO: 프로그램 구현
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val name = Console.readLine()
    println("시도할 횟수는 몇 회인가요?")
    val attempts = Console.readLine()

    val (isRacerNameValid, racerName) = checkRacerName(name)
    val maxAttemptCount = checkRaceAttempts(attempts)

    if (isRacerNameValid) {
        println("자동차 경주를 시작합니다.")
    }
}