package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getRacingCarNames(): List<String> {
        println(INPUT_CAR_NAMES_MESSAGE)

        val input = Console.readLine().trim()
        checkInputIsEmpty(input)

        return input.split(",").map { it.trim() }
    }

    fun getRacingTryCount(): String {
        println(INPUT_TRY_COUNT_MESSAGE)

        val input = Console.readLine().trim()
        checkInputIsEmpty(input)

        return input
    }

    private fun checkInputIsEmpty(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException(INVALID_INPUT_EMPTY)
    }

    companion object {
        const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        const val INVALID_INPUT_EMPTY = "입력이 필요합니다."
    }
}