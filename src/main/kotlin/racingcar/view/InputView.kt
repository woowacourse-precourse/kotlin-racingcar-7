package racingcar.view

import camp.nextstep.edu.missionutils.Console
import java.util.prefs.Preferences.MAX_NAME_LENGTH

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

    private fun validateNameLength(names: List<String>) {
        require(names.all { it.isNotBlank() && it.length <= MAX_NAME_LENGTH }) {
            ERROR_NAME_LENGTH
        }
    }

    companion object {
        const val MESSAGE_ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val ERROR_EMPTY_INPUT = "자동차 이름을 입력해야 합니다."
        const val ERROR_INVALID_SEPARATOR = "자동차 이름은 쉼표(,)로 구분해야 합니다."
        const val ERROR_NAME_LENGTH = "자동차 이름은 1자 이상 5자 이하여야 합니다."
        const val COMMA = ","
    }
}