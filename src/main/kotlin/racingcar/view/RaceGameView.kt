package racingcar.view

import camp.nextstep.edu.missionutils.Console

const val CAR_NAMES_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val NOT_FOUND_INPUT_MESSAGE = "입력값이 비어있습니다. 다시 입력해주세요."
const val TRY_COUNT_PROMPT_MESSAGE = "시도할 횟수는 몇 회인가요?"
const val INVALID_TRY_COUNT_MESSAGE = "시도 횟수는 1 이상의 값이어야 합니다."
const val CAR_NAMES_REGEX = "^(\\w+,)+\\w+$"
const val INVALID_CAR_NAME_CHAR_MESSAGE = "자동차 이름에 쉼표를 제외한 다른 특수문자가 포함될 수 없습니다. 다시 입력해주세요."

class RaceGameView {
    fun inputCarNames(): String {
        println(CAR_NAMES_PROMPT_MESSAGE)
        val carNames: String = readLine()

        validateNonEmpty(carNames)
        validateCarNamesFormat(carNames)

        return carNames
    }

    fun inputTryCount(): Int {
        println(TRY_COUNT_PROMPT_MESSAGE)
        val tryCountInput: String = readLine()
        validateNonEmpty(tryCountInput)

        val parsedTryCount = tryCountInput.toInt()
        validateNumeric(parsedTryCount)

        return parsedTryCount
    }

    private fun readLine(): String {
        return Console.readLine()
    }

    private fun validateCarNamesFormat(input: String) {
        if (!input.matches(Regex(CAR_NAMES_REGEX))) {
            throw IllegalArgumentException(INVALID_CAR_NAME_CHAR_MESSAGE)
        }
    }

    private fun validateNonEmpty(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException(NOT_FOUND_INPUT_MESSAGE)
        }
    }

    private fun validateNumeric(input: Int) {
        if (input <= 0) {
            throw IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE)
        }
    }
}
