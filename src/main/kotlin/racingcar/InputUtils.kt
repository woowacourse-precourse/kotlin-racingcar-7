package racingcar

import camp.nextstep.edu.missionutils.Console

fun readCarNames(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return try {
        Console.readLine() ?: ""
    } catch (e: Exception) {
        ""
    }
}

fun readTryNumber(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return try {
        val input = Console.readLine() ?: throw IllegalArgumentException("입력이 필요합니다.")
        val number = input.toIntOrNull() ?: throw IllegalArgumentException("정수를 입력해주세요.")
        if (number < 0) {
            throw IllegalArgumentException("음수를 입력할 수 없습니다.")
        }
        if (number == 0) {
            throw IllegalArgumentException("경주 횟수는 1 이상이어야 합니다.")
        }
        number
    } catch (e: Exception) {
        throw IllegalArgumentException("잘못된 값이 입력되었습니다.")
    }
}