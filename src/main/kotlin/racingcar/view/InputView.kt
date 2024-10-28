package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputCarNames(): List<String> {
        println(MESSAGE_ENTER_CAR_NAMES)
        val input = Console.readLine().orEmpty()
        validateEmptyInput(input)
        validateSeparator(input)

        val names = splitAndTrimNames(input)
        validateCarNames(names)

        return names
    }

    fun inputRounds(): Int {
        println(MESSAGE_ENTER_ROUNDS)
        val input = Console.readLine().orEmpty()
        println()

        return parseRounds(input)
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

    private fun validateCarNames(names: List<String>) {
        validateNameLength(names)
        validateDuplicateNames(names)
        validateNumericNames(names)
    }

    private fun validateNameLength(names: List<String>) {
        require(names.all { it.isNotBlank() && it.length <= MAX_NAME_LENGTH }) {
            ERROR_NAME_LENGTH
        }
    }

    private fun validateDuplicateNames(names: List<String>) {
        require(names.distinct().size == names.size) {
            ERROR_DUPLICATE_NAMES
        }
    }

    private fun validateNumericNames(names: List<String>) {
        require(names.none { it.all { char -> char.isDigit() } }) {
            ERROR_NUMERIC_NAMES
        }
    }


    private fun parseRounds(input: String): Int {
        val rounds = input.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER)
        validatePositiveRounds(rounds)

        return rounds
    }

    private fun validatePositiveRounds(rounds: Int) {
        require(rounds in 1..Int.MAX_VALUE) { ERROR_NON_POSITIVE_ROUNDS }
    }

    companion object {
        const val MESSAGE_ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val MESSAGE_ENTER_ROUNDS = "시도할 횟수는 몇 회인가요?"
        const val ERROR_EMPTY_INPUT = "자동차 이름을 입력해야 합니다."
        const val ERROR_INVALID_SEPARATOR = "자동차 이름은 쉼표(,)로 구분해야 합니다."
        const val ERROR_NAME_LENGTH = "자동차 이름은 1자 이상 5자 이하여야 합니다."
        const val ERROR_DUPLICATE_NAMES = "자동차 이름은 중복될 수 없습니다."
        const val ERROR_INVALID_NUMBER = "이동 횟수는 숫자로 입력해야 합니다."
        const val ERROR_NON_POSITIVE_ROUNDS = "입력한 이동 횟수가 범위를 벗어났습니다."
        const val ERROR_NUMERIC_NAMES = "자동차 이름은 숫자일 수 없습니다."
        const val COMMA = ","
        const val MAX_NAME_LENGTH = 5
    }
}