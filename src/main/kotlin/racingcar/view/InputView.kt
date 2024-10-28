package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputCarNames() {
        println(MESSAGE_ENTER_CAR_NAMES)
        val input = Console.readLine().orEmpty()
        validateEmptyInput(input)
        validateSeparator(input)

        val names = splitAndTrimNames(input)
    }

    private fun validateEmptyInput(input: String) {
        if (input.isBlank()) throw IllegalArgumentException(ERROR_EMPTY_INPUT)
    }

    private fun validateSeparator(input: String) {
        val names = input.split(COMMA).map { it.trim() }
        require(names.isNotEmpty() && names.all { it.isNotBlank() }) {
            ERROR_INVALID_SEPARATOR
        }
    }

    private fun splitAndTrimNames(input: String): List<String> {
        return input.split(COMMA).map { it.trim() }
    }

    companion object {
        const val MESSAGE_ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val ERROR_EMPTY_INPUT = "자동차 이름을 입력해야 합니다."
        const val ERROR_INVALID_SEPARATOR = "자동차 이름은 쉼표(,)로 구분해야 합니다."
        const val COMMA = ","
    }
}