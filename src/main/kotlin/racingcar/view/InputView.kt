package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputCarNames() {
        println(MESSAGE_ENTER_CAR_NAMES)
        val input = Console.readLine().orEmpty()
        validateEmptyInput(input)
    }

    private fun validateEmptyInput(input: String) {
        if (input.isBlank()) throw IllegalArgumentException(ERROR_EMPTY_INPUT)
    }

    companion object {
        const val MESSAGE_ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val ERROR_EMPTY_INPUT = "자동차 이름을 입력해야 합니다."
    }
}