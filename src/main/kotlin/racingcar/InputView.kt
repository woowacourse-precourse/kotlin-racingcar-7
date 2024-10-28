package racingcar

import camp.nextstep.edu.missionutils.Console

class InputView {
    // 자동차 이름 입력 받기
    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine() ?: throw IllegalArgumentException("자동차 이름 입력이 필요합니다.")
        return input.split(",").map { it.trim() }
    }

    // 시도할 횟수 입력 받기
    fun getTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine() ?: throw IllegalArgumentException("시도 횟수 입력이 필요합니다.")
        return input.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해 주세요.")
    }
}