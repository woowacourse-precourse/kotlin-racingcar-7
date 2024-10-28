package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        val carNames = readCarNames()
        val attempts = readAttempts()

        val cars = carNames.map { Car(it) }
        val game = RacingGame(cars, attempts)
        game.start()
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("입력이 잘못되었습니다. 프로그램을 종료합니다.")
    }
}

private fun readCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    val names = input.split(",").map { it.trim() }

    require(names.all { it.length <= 5 }) {
        "자동차 이름은 5자 이하만 가능합니다."
    }

    return names
}

private fun readAttempts(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val input = Console.readLine()
    val attempts = input.toIntOrNull()
        ?: throw IllegalArgumentException("숫자를 입력해야 합니다.")

    require(attempts > 0) {
        throw IllegalArgumentException("횟수는 0회 이상이어야 합니다.")
    }

    return attempts
}
